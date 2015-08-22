package com.yaoge.annotation.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类FirstAnno.java的实现描述：测试
 * 
 * @author yaoge 2015年8月1日 下午3:56:23
 */

@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodAnnotation {

    public String value = "hello";

    public String name() default "hello name";

    public String pwd() default "hello password";
}
