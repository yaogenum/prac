package com.yaoge.annotation.proxyTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import com.yaoge.annotation.myannotation.ClassAnnotation;
import com.yaoge.annotation.myannotation.FieldAnnotation;
import com.yaoge.annotation.myannotation.MethodAnnotation;
import com.yaoge.annotation.myannotation.ParameterAnnotation;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 类AnnotationProxy.java的实现描述：JDK动态代理，测试Annotation功能
 * 
 * @author yaoge 2015年8月1日 下午6:44:01
 */
public class AnnotationProxy implements MethodInterceptor {

    private Object target;

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事物开始");
        try {
            @SuppressWarnings("rawtypes")
            Class t = target.getClass();
            // Class t = Class.forName();
          

            dealWithClassName(t);
            dealWithFiled(t);
            dealWithMethod(t);
            dealWithParamsbyCglibAndReflect(method ,args);
                     // 使用javassit方式进行获取
            getParams(t, "testParameter");
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("事物结束");
        return proxy.invokeSuper(obj, args);

    }

    public void dealWithFiled(Class<?> T) {
        Field[] fileds = T.getDeclaredFields();
        for (Field filed : fileds) {
            if (filed.getDeclaredAnnotations().length > 0) {
                if (filed.isAnnotationPresent(com.yaoge.annotation.myannotation.FieldAnnotation.class)) {
                    FieldAnnotation fa = filed.getAnnotation(com.yaoge.annotation.myannotation.FieldAnnotation.class);
                    System.out.println("filed:" + fa.methodValue());
                }
            }
        }

    }
    
    public void dealWithClassName(Class<?> t) {
        if (t.isAnnotationPresent(com.yaoge.annotation.myannotation.ClassAnnotation.class)) {
            ClassAnnotation c = (ClassAnnotation) t.getAnnotation(com.yaoge.annotation.myannotation.ClassAnnotation.class);
            System.out.println(c.className());
        }
     
    }
    
    public void dealWithMethod(Class<?> t) {
        Method[] methods = t.getMethods();
        for (Method m : methods) {
            if (m.getDeclaredAnnotations().length > 0) {
                if (m.isAnnotationPresent(com.yaoge.annotation.myannotation.MethodAnnotation.class)) {
                    MethodAnnotation ma = m.getAnnotation(com.yaoge.annotation.myannotation.MethodAnnotation.class);
                    System.out.println("method:" + ma.name() + ";" + ma.pwd());
                }
            }
        }
   
    }
    
    public void dealWithParamsbyCglibAndReflect(Method method,Object[] args) {
        // 使用反射与cglib，注解两者结合的方式获取参数名称与值，进行切面（代理）处理一些行为
        if (method.getName().equalsIgnoreCase("testParameter")) {
            if (method.getParameterAnnotations().length > 0) {
                Annotation[][] a = method.getParameterAnnotations();
                for (int index = 0; index < args.length; index++) {
                    Annotation[] aa = a[index];
                    if (null != aa || aa.length > 0) {
                        for (Annotation aaa : aa) {
                            ParameterAnnotation pa = (ParameterAnnotation) aaa;
                            System.out.println("parameter name:" + pa.parameter() + ";value:" + args[index]);
                        }
                    }
                }
            }
        }


    }

    public String[] getParams(Class<?> T, String methodName) {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(T.getName());
            CtMethod cm = cc.getDeclaredMethod(methodName);

            // 使用javaassist的反射方法获取方法的参数名
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if (attr == null) {
                // exception
            }
            String[] paramNames = new String[cm.getParameterTypes().length];
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            for (int i = 0; i < paramNames.length; i++)
                paramNames[i] = attr.variableName(i + pos);
            // paramNames即参数名
            for (int i = 0; i < paramNames.length; i++) {
                System.out.println("javassit:" + paramNames[i]);
            }
            return paramNames;
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

}
