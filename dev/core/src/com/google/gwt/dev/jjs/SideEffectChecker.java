package com.google.gwt.dev.jjs;

import com.google.gwt.dev.jjs.ast.Context;
import com.google.gwt.dev.jjs.ast.JBinaryOperation;
import com.google.gwt.dev.jjs.ast.JExpression;
import com.google.gwt.dev.jjs.ast.JFieldRef;
import com.google.gwt.dev.jjs.ast.JLocalRef;
import com.google.gwt.dev.jjs.ast.JMethod;
import com.google.gwt.dev.jjs.ast.JMethodCall;
import com.google.gwt.dev.jjs.ast.JParameterRef;
import com.google.gwt.dev.jjs.ast.JProgram;
import com.google.gwt.dev.jjs.ast.JVisitor;
import com.google.gwt.dev.jjs.impl.OptimizerContext;

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
 * At this time, immutable is not considered, and "pure functions" have no special handling.
 */
public class SideEffectChecker {
  private static final String NAME = SideEffectChecker.class.getSimpleName();
  private static class MethodSideEffects extends JVisitor {
    private final JMethod method;
    private final BitSet modifiedParameters;
    private Result result;

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
        if (lhs instanceof JParameterRef || lhs instanceof JLocalRef) {
          return true;
        }
        if (lhs instanceof JFieldRef) {
          JFieldRef f = (JFieldRef) lhs;
          // assigning to a static field is always a side effect
          if (f.getField().isStatic()) {
            updateResult(Result.MODIFIES_GLOBAL_STATE);
            return false;
          }
          if (f.getInstance() instanceof JParameterRef p && p.getParameter().isFinal()) {
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
      return true;
    }

    private void updateResult(Result newResult) {
      if (result == null || newResult.ordinal() > result.ordinal()) {
        result = newResult;
      }
    }

    @Override
    public boolean visit(JMethodCall x, Context ctx) {
      if (x.getTarget().isStatic() || x.getTarget().isConstructor()) {
        // Wait and see if this method was permitted or not
        return true;
      } else {
        // Instance method call, assume side effects unless it can be made static in a later pass
        updateResult(Result.MODIFIES_GLOBAL_STATE);
        return false;
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
  public static void exec(JProgram jprogram, OptimizerContext optimizerContext) {
    Set<JMethod> modifiedMethods =
        optimizerContext.getModifiedMethodsSince(optimizerContext.getLastStepFor(NAME));

    Map<JMethod, MethodSideEffects> methodResults = new HashMap<>();
    new JVisitor() {
      @Override
      public boolean visit(JMethod x, Context ctx) {
        if (x.isConstructor() || x.isStatic()) {
          // Analyze method body for side effects, record dependencies
          methodResults.put(x, new MethodSideEffects(x));
        }
        return false;
      }
    }.accept(jprogram);

    for (JMethod method : methodResults.keySet()) {
      if (!method.hasSideEffects()) {
        continue;
      }
      if (methodResults.get(method).result() == MethodSideEffects.Result.MODIFIES_GLOBAL_STATE) {
        method.setHasSideEffects(true);
        continue;
      }
      if (methodResults.get(method).result() == MethodSideEffects.Result.MODIFIES_PARAMETERS) {
        method.setHasSideEffects(true);
        continue;
      }

      boolean hasSideEffects = false;
      for (JMethod callee : optimizerContext.getCallees(Set.of(method))) {
        if (!callee.hasSideEffects()) {
          continue;
        }
        if (methodResults.get(callee).result() == MethodSideEffects.Result.MODIFIES_GLOBAL_STATE) {
          hasSideEffects = true;
          break;
        }
        if (methodResults.get(callee).result() == MethodSideEffects.Result.MODIFIES_PARAMETERS) {
          //TODO check the param, if it is a local and was assigned new something locally created, this
          //     is allowed
          hasSideEffects = true;
          break;
        }
      }
      method.setHasSideEffects(hasSideEffects);
      optimizerContext.markModified(method);
    }

    optimizerContext.setLastStepFor(NAME, optimizerContext.getOptimizationStep());
    optimizerContext.incOptimizationStep();
  }
}
