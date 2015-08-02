package com.yaoge.annotation.mytest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import com.yaoge.annotation.myannotation.ClassAnnotation;
import com.yaoge.annotation.myannotation.FieldAnnotation;
import com.yaoge.annotation.myannotation.MethodAnnotation;
import com.yaoge.annotation.proxyTest.AnnotationProxy;

/**
 * 类MainClass.java的实现描述：TODO 类实现描述
 * 
 * @author yaoge 2015年8月1日 下午5:04:46
 */
public class MainClass {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static  void main (String args[]) {
        TestAnnotation a = new TestAnnotation();
      ///  a.testA("1", "2");
        
        AnnotationProxy proxy = new AnnotationProxy();
        TestAnnotation test = (TestAnnotation)proxy.getInstance(a);
        test.testA("yaoge","22two");
        System.out.println("middler");
       test.testParameter("parameter is test!!!");
        System.out.println("end");
    }
}
