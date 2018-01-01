package org.javase.lang.anotation;

/**
 * 注解的生命周期：source阶段->class阶段->字节码阶段，默认为class阶段
 * 
 * Override:SOURCE
 * deprecated：RUNTIME
 * SuppressWarnings：SOURCE
 * 
 * 
 * @author kevin
 *
 */
@MyAnotation(value = "hello anotation", arr= {"1","2"})
public class AnotationTest {

	/**
	 * 标记方法过时，编译阶段不出现警告
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
		// 反射注解 获取反射的各种属性
		if(AnotationTest.class.isAnnotationPresent(MyAnotation.class)) {
			MyAnotation annotation = AnotationTest.class.getAnnotation(MyAnotation.class);
			System.out.println(annotation);//@org.javase.lang.anotation.MyAnotation() 
			System.out.println(annotation.value());//hello anotation
			System.out.println(annotation.arr().length);//2
			System.out.println(annotation.tranfficLamp().nextLamp());//GREEN
			System.out.println(annotation.tranfficLamp());//RED
			System.out.println(annotation.metaAnation().value());//hello
		}
	}
	
	/**
	 * 标记方法过时
	 */
	@Deprecated
	public static void sayHello() {
		System.out.println("hello");
	}

}
