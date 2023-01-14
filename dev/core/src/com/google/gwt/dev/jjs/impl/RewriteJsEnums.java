package com.google.gwt.dev.jjs.impl;

import com.google.gwt.dev.jjs.InternalCompilerException;
import com.google.gwt.dev.jjs.ast.Context;
import com.google.gwt.dev.jjs.ast.JAbstractMethodBody;
import com.google.gwt.dev.jjs.ast.JBinaryOperation;
import com.google.gwt.dev.jjs.ast.JBinaryOperator;
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
import com.google.gwt.dev.jjs.ast.JIntLiteral;
import com.google.gwt.dev.jjs.ast.JLiteral;
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
import com.google.gwt.dev.jjs.ast.js.JMultiExpression;
import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.google.gwt.thirdparty.guava.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        Map<JField, JField> replacementFields = new HashMap<>();
        Map<JMethod, JMethod> replacementMethods = new HashMap<>();
        for (JDeclaredType declaredType : program.getDeclaredTypes()) {
            if (!declaredType.isJsEnum()) {
                continue;
            }
//            ((JClassType) declaredType).setSuperClass(null);//cant do this, need to just prevent ordinal() etc from being called on Enum
            JType actualType;
            if (declaredType.jsEnumHasCustomValue()) {
                JField value = declaredType.getFields().stream().filter(f -> f.getName().equals("value")).findFirst().get();
                actualType = value.getType();
            } else {
                actualType = JPrimitiveType.DOUBLE;
            }
            declaredType.setJsEnumCustomValueType(actualType);
//            JType valueType = declaredType.getJsEnumCustomValueType();
//            List<JField> fields = declaredType.getFields();
//            for (int i = fields.size() - 1; i >= 0; i--) {
//                JField field = fields.get(i);
//                if (field.isStatic()) {
//                    declaredType.removeField(i);
//                    // disposition should be compile time constant if non-native
//                    JField replacement = new JField(field.getSourceInfo(), field.getName(), declaredType, valueType, true, JField.Disposition.NONE);
//                    System.out.println(field);
//                    replacementFields.put(field, replacement);
//                    declaredType.addField(replacement);
//                    System.out.println(replacement);
//                }
//            }

            List<JMethod> methods = declaredType.getMethods();
            for (int i = methods.size() - 1; i >= 0; i--) {
                JMethod method = methods.get(i);
                if (method.isStatic() || method.isSynthetic()) {
                    // Skip, already static
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
                JType thisParameterType = actualType;
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
//                System.out.println(method);
//                System.out.println(movedBody);
                replacement.setBody(movedBody);
//                System.out.println(replacement);

                RewriteMethodBody rewriter = new RewriteMethodBody(thisParam, varMap);
                rewriter.accept(movedBody);
//                System.out.println(replacement);

                replacementMethods.put(method, replacement);
                declaredType.addMethod(replacement);
            }
        }
        AutoboxUtils autobox = new AutoboxUtils(program);

        new JModVisitor() {
            /**
             * Rewrite .value to be the value itself, and rewrite instances to be the real fields.
             */
//            @Override
//            public void endVisit(JFieldRef x, Context ctx) {
//                if (!x.getField().getEnclosingType().isJsEnum()) {
//                    super.endVisit(x, ctx);
//                    return;
//                }
//
//                if (!x.getField().isStatic()) {
//                    if (x.getField().getName().equals("value")) {
//                        // someenumexpr.value is replaced with just someenumexpr
//                        ctx.replaceMe(x.getInstance());
//                    } else {
//                        //invalid! no other non-static fields allowed!
//                    }
//                } else {
//                    // EnumType.FOO to be replaced with the new EnumType.FOO that was just added
//
//                    JField replacementField = replacementFields.get(x.getField());
//                    if (replacementField == null) {
//                        System.out.println(x);
//                        throw new InternalCompilerException("Missing replacement field for JsEnum instance");
//                    }
//                    ctx.replaceMe(new JFieldRef(x.getSourceInfo(), null, replacementField, x.getEnclosingType()));
//                }
//
//            }

            // Find and remove assignment calls to our enum fields
            @Override
            public boolean visit(JDeclarationStatement x, Context ctx) {
                if (x.getVariableRef().getTarget() instanceof JEnumField) {
                    JEnumField enumField = (JEnumField) x.getVariableRef().getTarget();
                    JEnumType enumType = enumField.getEnclosingType();
                    if (enumType.isJsEnum()) {
//                        ctx.removeMe();
                        JExpression value;
                        if (enumType.jsEnumHasCustomValue()) {
                            // constructor value must be provided
                            value = ((JMethodCall) x.getInitializer()).getArgs().get(0);
                        } else {
                            value = JDoubleLiteral.get(enumField.ordinal());
//                            value = autobox.box(JDoubleLiteral.get(enumField.ordinal()), JPrimitiveType.DOUBLE);
//                            value = new JCastOperation(x.getSourceInfo(), program.getFromTypeMap(JPrimitiveType.DOUBLE.getWrapperTypeName()), JDoubleLiteral.get(enumField.ordinal()));
                        }
                        ctx.replaceMe(new JDeclarationStatement(x.getSourceInfo(), x.getVariableRef(), value));
                        return false;
                    }
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

                if (x.getTarget().getName().equals("ordinal")) {
                    //TODO this doesnt get called because the superclass defines ordinal
                    ctx.replaceMe(x.getInstance());
                } else {
                    JMethod replacementMethod = replacementMethods.get(x.getTarget());
                    if (replacementMethod == null) {
                        throw new InternalCompilerException("Missing replacement method for JsEnum instance methods");
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
}
