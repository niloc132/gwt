package com.google.gwt.dev.jjs.impl;

import com.google.gwt.dev.jjs.InternalCompilerException;
import com.google.gwt.dev.jjs.SourceInfo;
import com.google.gwt.dev.jjs.ast.Context;
import com.google.gwt.dev.jjs.ast.JAbstractMethodBody;
import com.google.gwt.dev.jjs.ast.JCastOperation;
import com.google.gwt.dev.jjs.ast.JClassType;
import com.google.gwt.dev.jjs.ast.JDeclarationStatement;
import com.google.gwt.dev.jjs.ast.JDeclaredType;
import com.google.gwt.dev.jjs.ast.JDoubleLiteral;
import com.google.gwt.dev.jjs.ast.JEnumField;
import com.google.gwt.dev.jjs.ast.JEnumType;
import com.google.gwt.dev.jjs.ast.JExpression;
import com.google.gwt.dev.jjs.ast.JField;
import com.google.gwt.dev.jjs.ast.JFieldRef;
import com.google.gwt.dev.jjs.ast.JMethod;
import com.google.gwt.dev.jjs.ast.JMethodCall;
import com.google.gwt.dev.jjs.ast.JModVisitor;
import com.google.gwt.dev.jjs.ast.JParameter;
import com.google.gwt.dev.jjs.ast.JParameterRef;
import com.google.gwt.dev.jjs.ast.JPrimitiveType;
import com.google.gwt.dev.jjs.ast.JProgram;
import com.google.gwt.dev.jjs.ast.JThisRef;
import com.google.gwt.dev.jjs.ast.JType;
import com.google.gwt.dev.jjs.ast.RuntimeConstants;
import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.google.gwt.thirdparty.guava.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Rewrite all JsEnums to something closer to a java class with static+final fields, and remove
 * the {@code value} field if the type has a custom value type. Also, must rewrite Java methods
 * calls on the enum into static methods where the enum constant is the first argument.
 *
 * For now, we forbid methods on the enum instances, but could rewrite those as switch/case
 * statements.
 */
public class RewriteJsEnums {

    /**
     * When code is moved from an instance method to a static method, all
     * thisRefs must be replaced with paramRefs to the synthetic this param.
     * ParameterRefs also need to be targeted to the params in the new method.
     */
    private static class RewriteMethodBody extends JModVisitor {

        private final JParameter thisParam;
        private final Map<JParameter, JParameter> varMap;

        public RewriteMethodBody(JParameter thisParam, Map<JParameter, JParameter> varMap) {
            this.thisParam = thisParam;
            this.varMap = varMap;
        }

        @Override
        public void endVisit(JParameterRef x, Context ctx) {
            JParameter param = varMap.get(x.getTarget());
            ctx.replaceMe(param.makeRef(x.getSourceInfo()));
        }

        @Override
        public void endVisit(JThisRef x, Context ctx) {
            ctx.replaceMe(thisParam.makeRef(x.getSourceInfo()));
        }
    }


    public static void exec(JProgram program) {
        // rewrite each instance to be a static reference to the actual value
        Map<JMethod, JMethod> replacementMethods = new HashMap<>();
        for (JDeclaredType declaredType : program.getDeclaredTypes()) {
            if (!declaredType.isJsEnum()) {
                continue;
            }
            final JType actualType;
            if (declaredType.jsEnumHasCustomValue()) {
                JField value = declaredType.getFields().stream().filter(f -> f.getName().equals("value")).findFirst().get();
                actualType = value.getType();
            } else {
                // expose the ordinal itself
                actualType = JPrimitiveType.INT;
            }
            declaredType.setJsEnumCustomValueType(actualType);

            List<JMethod> methods = declaredType.getMethods();
            for (int i = methods.size() - 1; i >= 0; i--) {
                JMethod method = methods.get(i);
                if (method.isStatic() || method.isSynthetic()) {
                    // Skip, already static
                    continue;
                }
                if (method.isJsNative()) {
                    // it is assumed that these methods make sense in context of the underlying type
                    continue;
                }
                declaredType.removeMethod(i);
                if (method.isConstructor()) {
                    // constructor removed, nothing to replace it with
                    continue;
                }
                JMethod replacement = new JMethod(method.getSourceInfo(), "$" + method.getName(), declaredType, method.getType(), false, true, true, method.getAccess());
                replacement.setInliningMode(method.getInliningMode());
                replacement.setHasSideEffects(method.hasSideEffects());
                replacement.setSynthetic();
                replacement.addThrownExceptions(method.getThrownExceptions());
                if (method.isJsOverlay()) {
                    replacement.setJsOverlay();
                }

                // Do not strengthen to non null since the implicit NPE in instance dispatch is gone.
                JType thisParameterType = declaredType;
                // Setup parameters; map from the old params to the new params
                JParameter thisParam = replacement.createThisParameter(method.getSourceInfo(), thisParameterType);
                Map<JParameter, JParameter> varMap = Maps.newIdentityHashMap();
                for (JParameter oldVar : method.getParams()) {
                    JParameter newVar = replacement.cloneParameter(oldVar);
                    varMap.put(oldVar, newVar);
                }

                List<JType> originalParamTypes = Lists.newArrayList();
                originalParamTypes.add(thisParameterType);
                originalParamTypes.addAll(method.getOriginalParamTypes());
                replacement.setOriginalTypes(method.getOriginalReturnType(), originalParamTypes);

                // copied/modified from MakeCallsStatic
                JAbstractMethodBody movedBody = method.getBody();
                replacement.setBody(movedBody);

                RewriteMethodBody rewriter = new RewriteMethodBody(thisParam, varMap);
                rewriter.accept(movedBody);

                replacementMethods.put(method, replacement);
                declaredType.addMethod(replacement);
            }
        }

        new JModVisitor() {
            /**
             * Rewrite .value to be the value itself, and rewrite instances to be the real fields.
             */
            @Override
            public void endVisit(JFieldRef x, Context ctx) {
                JDeclaredType enumType = x.getField().getEnclosingType();
                if (!enumType.isJsEnum()) {
                    super.endVisit(x, ctx);
                    return;
                }

                if (!x.getField().isStatic()) {
                    if (x.getField().getName().equals("value")) {
                        // someenumexpr.value is replaced with just someenumexpr
                        ctx.replaceMe(uncheckedCast(x.getSourceInfo(), x.getInstance(), enumType.getJsEnumCustomValueType(), program));
                    } else {
                        //invalid! no other non-static fields allowed!
                        throw new IllegalStateException("Unexpected field in JsEnum: " + x.getField());
                    }
                }

            }

            /**
             * Find and rewrite initializers to assign the real value
             */
            @Override
            public boolean visit(JDeclarationStatement x, Context ctx) {
                if (x.getVariableRef().getTarget() instanceof JEnumField) {
                    JEnumField enumField = (JEnumField) x.getVariableRef().getTarget();
                    JEnumType enumType = enumField.getEnclosingType();
                    if (enumType.isJsEnum()) {
                        if (enumType.isJsNative()) {
                            // native enums must already have values, so just remove the initializer entirely
                            ctx.removeMe();
                            return false;
                        }
                        JExpression value;
                        if (enumType.jsEnumHasCustomValue()) {
                            // constructor value must be provided - args are "name", "ordinal", then the ctor arg, our value
                            value = ((JMethodCall) x.getInitializer()).getArgs().get(2);
                        } else {
                            // with no custom value, use the ordinal
                            value = JDoubleLiteral.get(enumField.ordinal());
                        }
                        JExpression cast = uncheckedCast(x.getSourceInfo(), value, enumType, program);
                        ctx.replaceMe(new JDeclarationStatement(x.getSourceInfo(), x.getVariableRef(), cast));
                        return false;
                    }
                }
                return super.visit(x, ctx);
            }


            @Override
            public boolean visit(JMethod x, Context ctx) {
                // avoid visiting the non-empty contents of native constructors
                if (x.isJsNative()) {
                    return false;
                }
                return super.visit(x, ctx);
            }

            /**
             * Except for ordinal(), staticify methods calls that reference each enum. All such methods are effectively final.
             *
             * Ordinal is rewritten to be the instance itself.
             */
            @Override
            public void endVisit(JMethodCall x, Context ctx) {
                if (x.getInstance() == null || !x.getInstance().getType().isJsEnum()) {
                    super.endVisit(x, ctx);
                    return;
                }

                if (x.getTarget().isStatic() || x.getTarget().isSynthetic()) {
                    super.endVisit(x, ctx);
                    return;
                }

                if (x.getTarget().isJsNative()) {
                    super.endVisit(x, ctx);
                    return;
                }
                JDeclaredType enumType = (JDeclaredType) x.getInstance().getType();

                if (x.getTarget().getName().equals("ordinal") && x.getTarget().getParams().isEmpty()) {
                    // cast the enum to int since ordinal() must return int
                    //TODO int is wrong, need to check enum's js type
                    ctx.replaceMe(uncheckedCast(x.getSourceInfo(), x.getInstance(), enumType.getJsEnumCustomValueType(), program));
                } else if (x.getTarget().getName().equals("compareTo") && x.getTarget().getParams().size() == 1) {
                    // for some enums, we can implement Comparable
                } else if (x.getTarget().getEnclosingType().equals(program.getIndexedType("Enum"))) {
                    // for now try to ignore this, see if super can help us out
                    super.endVisit(x, ctx);
                    return;
                } else {
                    JMethod replacementMethod = replacementMethods.get(x.getTarget());
                    if (replacementMethod == null) {
                        throw new InternalCompilerException("Missing replacement method for JsEnum instance method " + x);
                    }


                    JMethodCall newCall = new JMethodCall(x.getSourceInfo(), null, replacementMethod);
                    //TODO restore multiexpressions here and above
                    /*
                     * If the qualifier is a JMultiExpression, invoke on the last value. This
                     * ensures that clinits maintain the same execution order relative to
                     * parameters in deeply-inlined scenarios.
                     */
                    //   (a, b).foo() --> (a, foo(b))
                    // Or in checked mode:
                    //   (a, b).foo() --> (a, foo(checkNotNull(b)))
//                    if (original.getInstance() instanceof JMultiExpression) {
//                        JMultiExpression multi = (JMultiExpression) original.getInstance();
//                        int lastIndex = multi.getNumberOfExpressions() - 1;
//                        newCall.addArg(makeNullCheck(multi.getExpression(lastIndex), original));
//                        newCall.addArgs(original.getArgs());
//                        multi.setExpression(lastIndex, newCall);
//                        return multi;
//                    } else {
                        // The qualifier becomes the first argument.
                        //   a.foo(b) --> foo(a,b)
                        // or in checked mode:
                        //   a.foo(b) --> foo(checkNotNull(a),b)
//                    JMethod checkNotNull = program.getIndexedMethod(RuntimeConstants.EXCEPTIONS_CHECK_NOT_NULL);
//                    JMethodCall check = new JMethodCall(x.getSourceInfo(), null, checkNotNull);
//                    check.addArg(x.getInstance());
                    newCall.addArg(x.getInstance());//newCall.addArg(check);
                        newCall.addArgs(x.getArgs());
//                    }




                    ctx.replaceMe(newCall);
                }

            }
        }.accept(program);
    }

    private static JExpression uncheckedCast(SourceInfo sourceInfo, JExpression value, JType type, JProgram program) {
        JMethod cast = program.getIndexedMethod(RuntimeConstants.RUNTIME_UNCHECKED_CAST);
        JExpression result = new JMethodCall(sourceInfo, null, cast, value);

        JClassType classType;
        JPrimitiveType primitiveType;
        if (type instanceof JClassType) {
            //only String is possible here
            classType = (JClassType) type;
            primitiveType = null;
            return result;//new JCastOperation(sourceInfo, classType, result);
        } else if (type instanceof JPrimitiveType) {
            if (type == JPrimitiveType.BOOLEAN) {
//                classType = (JClassType) program.getFromTypeMap("java.lang.Boolean");
                JMethod unbox = program.getIndexedMethod("Boolean.booleanValue");
                return new JMethodCall(sourceInfo, result, unbox);

            } else {
                primitiveType = (JPrimitiveType) type;
                assert primitiveType != JPrimitiveType.LONG && primitiveType != JPrimitiveType.VOID;
                classType = (JClassType) program.getFromTypeMap("java.lang.Double");

//                result = new JCastOperation(sourceInfo, classType, result);

                JMethod unbox = null;
                try {
                    unbox = classType.getMethods().stream().filter(m -> m.getName().equals(primitiveType.getName() + "Value")).findFirst().get();
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }
                return new JMethodCall(sourceInfo, result, unbox);
            }
        } else {
            throw new IllegalStateException("Unexpected type " + type);
        }
//        if (classType != null) {
//            result = new JCastOperation(sourceInfo, classType, result);
//        }
//        if (primitiveType != null) {
//            JMethod unbox = null;
//            try {
//                unbox = classType.getMethods().stream().filter(m -> m.getName().equals(primitiveType.getName() + "Value")).findFirst().get();
//            } catch (NoSuchElementException e) {
//                e.printStackTrace();
//            }
//            result = new JMethodCall(sourceInfo, result, unbox);
//        }
//
//        return result;
    }
}
