package org.javase.lang.reflect;

/**
 * Class类的测试     ==> java的反射就是把类中的各种成分映射成这个类
 * 
 * @author kevin
 *
 */
public class ClassTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		String str1 = "test";
		Class c1 = str1.getClass();
		Class c2 = String.class;
		Class c3 = Class.forName("java.lang.String");
		System.out.println(c1 == c2);// true
		System.out.println(c1 == c3);// true
		
		System.out.println(c1.isPrimitive());// false 引用类型
		System.out.println(int.class.isPrimitive());// true 基本类型
	}
}
