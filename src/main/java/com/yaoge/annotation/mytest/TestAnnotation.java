package com.yaoge.annotation.mytest;

import com.yaoge.annotation.myannotation.MethodAnnotation;
import com.yaoge.annotation.myannotation.ParameterAnnotation;
import com.yaoge.annotation.myannotation.ClassAnnotation;
import com.yaoge.annotation.myannotation.FieldAnnotation;

/**
 * 
 * 类TestAnnotation.java的实现描述：ceshi1 
 * @author yaoge 2015年8月1日 下午4:12:03
 */
@ClassAnnotation(className="TestAnnotation")
public class TestAnnotation {
    @FieldAnnotation(methodValue="okok pro1")
    private String pro1;
    
    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }
    
    @MethodAnnotation(name="hello name name",pwd="hello password password")
    public void  testA (String name ,String pwd) {
        //System.out.println(name+";"+pwd);
    }
    
    public void testParameter(@ParameterAnnotation(parameter="parameter") String parameter) {
       // System.out.println(parameter);
    }
    
   
}
