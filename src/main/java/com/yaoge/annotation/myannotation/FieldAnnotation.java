package com.yaoge.annotation.myannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
/**
 * 
 * 类FieldAnnotation.java的实现描述：oplog 处理
 * @author yaoge 2015年8月1日 下午4:46:30
 */
public @interface FieldAnnotation {
    String field = "field1";
    String methodValue() default "annotation field" ;
}
