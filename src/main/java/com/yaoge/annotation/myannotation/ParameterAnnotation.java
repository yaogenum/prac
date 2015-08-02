package com.yaoge.annotation.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类ParameterAnnotation.java的实现描述：TODO 类实现描述 
 * @author yaoge 2015年8月1日 下午4:48:03
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParameterAnnotation {
    String parameter() default "parameter" ;
}
