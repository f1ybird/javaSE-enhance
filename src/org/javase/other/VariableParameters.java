package org.javase.other;

/**
 * 可变参数,自动装箱，拆箱
 * 
 * @author kevin
 *
 */
public class VariableParameters {

	public static void main(String[] args) {
		System.out.println("add(1)=" + add(1));
		System.out.println("add(1,2)=" + add(1,2));
		System.out.println("add(1,2,3)=" +  add(1,2,3));
		System.out.println("add(1,2,3,4)=" +  add(1,2,3,4));
		System.out.println("add(1,2,3,4,6)=" +  add(1,2,3,4,6));
		
		Integer i1 = 1;
		Integer i2 = 1;
		System.out.println(i1 == i2);// true
		// 享元模式 -128-127范围内会缓存，超过会重新创建对象
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3 == i4);// false
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1 == str2);// false
	}

	private static int add(int i, int...args) {
		int result = i;
//		for (int j = 0; j < args.length; j++) {
//			result += args[j];
//		}
		for(int arg : args) {
			result += arg;
		}
		return result;
	}

}
