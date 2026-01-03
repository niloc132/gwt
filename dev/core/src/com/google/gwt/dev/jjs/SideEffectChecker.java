/*
 * Copyright 2025 GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.dev.jjs;

import com.google.gwt.dev.jjs.ast.Context;
import com.google.gwt.dev.jjs.ast.JBinaryOperation;
import com.google.gwt.dev.jjs.ast.JDeclarationStatement;
import com.google.gwt.dev.jjs.ast.JExpression;
import com.google.gwt.dev.jjs.ast.JField;
import com.google.gwt.dev.jjs.ast.JFieldRef;
import com.google.gwt.dev.jjs.ast.JLocalRef;
import com.google.gwt.dev.jjs.ast.JMethod;
import com.google.gwt.dev.jjs.ast.JMethodCall;
import com.google.gwt.dev.jjs.ast.JParameterRef;
import com.google.gwt.dev.jjs.ast.JPostfixOperation;
import com.google.gwt.dev.jjs.ast.JPrefixOperation;
import com.google.gwt.dev.jjs.ast.JProgram;
import com.google.gwt.dev.jjs.ast.JThisRef;
import com.google.gwt.dev.jjs.ast.JThrowStatement;
import com.google.gwt.dev.jjs.ast.JVisitor;
import com.google.gwt.dev.jjs.impl.OptimizerContext;
import com.google.gwt.dev.jjs.impl.OptimizerStats;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Visits functions and identifies which have no side effects. Operates in two passes, first
 * identifying side effects present within each function and dependencies on other functions, then
 * once all functions have been visited, revisit to check dependencies.
 * <p>
 * Only applies to static methods and constructors. Instance methods are likely possible, but
 * require checking all implementations, and most instance methods where this would matter will be
 * made static anyway.
 * <p>
 * JsInterop methods are assumed to have side effects unless annotated otherwise. Property access
 * is assumed to have no side effects.
 * <p>
 * Constructors are allowed to perform operations that otherwise would appear to be a side effect,
 * as if the constructor was actually just a static factory method. Leaking "this" to another method
 * or assignment is only safe when that would normally be safe for any other parameter.
 * <p>
 * Methods which modify their parameters are considered to have side effects, but if a caller
 * otherwise has no side effects and passes in a locally created object, that operation is
 * considered side effect free. This may seem at first to be an unnecessary distinction, but it
 * enables pruning unused results built over several method calls like collections, StringBuilders,
 * etc. Not all use cases will work every time, and some may require multiple optimizations passes.
 * <p>
 * At this time, immutability is not considered, and "pure functions" have no special handling.
 */
public class SideEffectChecker {
  private static final String NAME = SideEffectChecker.class.getSimpleName();
  private static class MethodSideEffects extends JVisitor {
    private final JMethod method;
    private final BitSet modifiedParameters;
    private Result result = Result.PURE;

    private MethodSideEffects(JMethod method) {
      this.method = method;
      this.modifiedParameters = new BitSet(method.getParams().size());
      accept(method.getBody());
    }

    @Override
    public boolean visit(JBinaryOperation x, Context ctx) {
      if (x.isAssignment()) {
        // if the lhs is a local/param, we can ignore
        JExpression lhs = x.getLhs();
        return validateAssignment(lhs);
      }
      return true;
    }

    private boolean validateAssignment(JExpression expr) {
      if (expr instanceof JParameterRef || expr instanceof JLocalRef) {
        return true;
      }
      // If the assignment is to a field, we need to check what holds the field
      if (expr instanceof JFieldRef) {
        JFieldRef f = (JFieldRef) expr;
        // assigning to a static field is always a side effect
        if (f.getField().isStatic()) {
          updateResult(Result.MODIFIES_GLOBAL_STATE);
          return false;
        }
        if (f.getInstance() instanceof JThisRef && method.isConstructor()) {
          // Assigning to our own fields in a constructor is allowed, doesn't count as a side effect
          return true;
        }
        if (f.getInstance() instanceof JParameterRef p && p.getParameter().isFinal()) {
          // Assigning to a field of a final param is considered modifying the parameter.
          // Technically a side effect, but might be okay for the caller (e.g. setters which
          // have been made static).
          modifiedParameters.set(method.getParams().indexOf(p.getParameter()));
          updateResult(Result.MODIFIES_PARAMETERS);
          return true;
        } else if (f.getInstance() instanceof JLocalRef l && l.getLocal().isFinal()) {
          if (l.getLocal().getInitializer() instanceof JMethodCall m && m.getTarget().isConstructor()) {
            // either the ctor is permitted, or the whole method isn't permitted
            return true;
          }
        }
        // Other fields are considered unsafe at this time
        updateResult(Result.MODIFIES_GLOBAL_STATE);
        return false;
      }
      // other assignments are considered unsafe at this time
      updateResult(Result.MODIFIES_GLOBAL_STATE);
      return false;
    }


    @Override
    public boolean visit(JMethodCall x, Context ctx) {
      if (!alwaysConsideredToHaveSideEffects(x.getTarget())) {
        // Wait and see if this method was permitted or not
        return true;
      } else {
        // Instance method call, assume side effects unless it can be made static in a later pass
        updateResult(Result.MODIFIES_GLOBAL_STATE);
        return false;
      }
    }

    @Override
    public boolean visit(JThrowStatement x, Context ctx) {
      // At this time, this is considered a side effect to avoid pruning checks
      return false;
    }

    @Override
    public boolean visit(JPostfixOperation x, Context ctx) {
      return validateAssignment(x.getArg());
    }

    @Override
    public boolean visit(JPrefixOperation x, Context ctx) {
      return validateAssignment(x.getArg());
    }

    @Override
    public boolean visit(JDeclarationStatement x, Context ctx) {
      if (x.getVariableRef().getTarget() instanceof JField f && f.isStatic()) {
        // For the purposes of the method graph, instance initializers are considered to not be side
        // effects, but the method itself will not be marked as side-effect free.
        updateResult(Result.MODIFIES_GLOBAL_STATE);
        return false;
      }

      return true;
    }

    private void updateResult(Result newResult) {
      if (result == null || newResult.ordinal() > result.ordinal()) {
        result = newResult;
      }
    }

    public Result result() {
      return result;
    }

    public BitSet modifiedParameters() {
      return modifiedParameters;
    }

    /**
     * Result disregards what methods are invoked by this method, checked afterwards from the call
     * graph.
     */
    enum Result {
      /**
       * Only local state is read and no state is modified. May include returning a newly created
       * value.
       */
      PURE,
      /**
       * Global state is read, but no state is modified - no side effects, but should not be
       * reordered.
       */
      READS_GLOBAL_STATE,
      /**
       * Modifies state of parameters, but not global state. Methods that call this may still be
       * considered pure or side-effect free if they pass in only local objects.
       */
      MODIFIES_PARAMETERS,
      /**
       * Modifies global state, can never be side effect free, and callers are never side effect
       * free.
       */
      MODIFIES_GLOBAL_STATE
    }
  }
  public static int exec(JProgram jprogram, OptimizerContext optimizerContext) {
    try (OptimizerStats stats = OptimizerStats.optimization(NAME)) {
      Set<JMethod> modifiedMethods =
          optimizerContext.getModifiedMethodsSince(optimizerContext.getLastStepFor(NAME));

      Map<JMethod, MethodSideEffects> methodResults = new HashMap<>();
      new JVisitor() {
        @Override
        public boolean visit(JMethod x, Context ctx) {
          if (!x.hasSideEffects()) {
            // Already known to have no side effects
            return false;
          }
          if (!alwaysConsideredToHaveSideEffects(x)) {
            // Analyze method body for side effects, record dependencies
            methodResults.put(x, new MethodSideEffects(x));
          }
          return false;
        }
      }.accept(jprogram);

      HashMap<JMethod, CheckStatus> results = new HashMap<>();
      for (JMethod method : methodResults.keySet()) {
        if (checkNoSideEffects(method, methodResults, optimizerContext, results)) {
//        System.out.println("Method " + method.toString() + " has no side effects");
          method.setHasSideEffects(false);
          stats.recordModified(1);
          optimizerContext.markModified(method);
        }
      }

      optimizerContext.setLastStepFor(NAME, optimizerContext.getOptimizationStep());
      optimizerContext.incOptimizationStep();

      return stats.getNumMods();
    }
  }
  enum CheckStatus { WORKING, NO_SIDE_EFFECTS, HAS_SIDE_EFFECTS }

  /**
   * Recursively check if a method has side effects, based on the per-method analysis results and
   * the static functions and constructors it calls.
   * @param method the method to check
   * @param methodResults precomputed per-method results
   * @param optimizerContext context to use to walk the call graph
   * @param visitedMethods a mape to hold results
   * @return true if the method definitely has no side effects, false if we either know it has side
   * effects or can't be sure
   */
  private static boolean checkNoSideEffects(JMethod method, Map<JMethod, MethodSideEffects> methodResults,
      OptimizerContext optimizerContext, Map<JMethod, CheckStatus> visitedMethods) {
    if (visitedMethods.containsKey(method)) {
      if (JProgram.isInit(method)) {
        return false;
      }
      // Return false for WORKING to avoid cycles. In theory recursive methods could be side-effect free,
      // but this approach can't handle that.
      // TODO some kind of predicate system to allow self/mutually recursive methods
      return visitedMethods.get(method) == CheckStatus.NO_SIDE_EFFECTS;
    }
    visitedMethods.put(method, CheckStatus.WORKING);
    boolean result = true;
    if (alwaysConsideredToHaveSideEffects(method)) {
      result = false;
    } else if (method.hasSideEffects()) {
      MethodSideEffects ownResults = methodResults.get(method);
      if (ownResults.result() == MethodSideEffects.Result.MODIFIES_GLOBAL_STATE) {
        result = false;
      } else if (ownResults.result() == MethodSideEffects.Result.MODIFIES_PARAMETERS) {
        result = false;
      } else {
        for (JMethod callee : optimizerContext.getCallees(Set.of(method))) {
          if (!callee.hasSideEffects()) {
            continue;
          }
          if (alwaysConsideredToHaveSideEffects(callee)) {
            result = false;
            break;
          }
          MethodSideEffects calleeResults = methodResults.get(callee);
          if (calleeResults.result() == MethodSideEffects.Result.MODIFIES_GLOBAL_STATE) {
            result = false;
            break;
          }
          if (calleeResults.result() == MethodSideEffects.Result.MODIFIES_PARAMETERS) {
            // TODO check if any modified params correspond to vars that are safe for us to modify
            // TODO also move this check into an earlier phase if possible, so we can propagate this
            //      state to callers
            result = false;
            break;
          }
          if (!checkNoSideEffects(callee, methodResults, optimizerContext, visitedMethods)) {
            result = false;
            break;
          }
        }
      }
    }

    visitedMethods.put(method, result ? CheckStatus.NO_SIDE_EFFECTS : CheckStatus.HAS_SIDE_EFFECTS);
    // After building our graph node, we still treat instance initializers as having side effects
    if (JProgram.isInit(method)) {
      return false;
    }
    return result;
  }

  private static boolean alwaysConsideredToHaveSideEffects(JMethod x) {
    // If explicitly marked as "no side effects", believe it
    if (!x.hasSideEffects()) {
      return false;
    }
    // TODO for reasons, we can't yet allow constructors to have no side effects.
    return x.isJsNative() || x.isJsniMethod() || JProgram.isClinit(x) || (!x.isConstructor() && !x.isStatic());
  }
}
