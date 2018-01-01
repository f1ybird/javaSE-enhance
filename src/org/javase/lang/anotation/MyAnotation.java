package org.javase.lang.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.javase.lang.anotation.MetaAnation;

import org.javase.other.EnumTest;

/**
 * 自定义注解
 * 生命周期为RUNTIME
 * 应用范围为：类和方法之上
 * 
 * @author kevin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnotation {
	
	// 普通类型(primitive)
	String value() default "hello";
	// 数组类型
	String[] arr() default {"1","2","3"};
	// 枚举类型
	EnumTest.TranfficLamp tranfficLamp() default EnumTest.TranfficLamp.RED;
	// 注解类型
	MetaAnation metaAnation() default @MetaAnation("hello");
}
