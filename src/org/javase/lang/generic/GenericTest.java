package org.javase.lang.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * 泛型初识
 * 
 * @author kevin
 *
 */
public class GenericTest {

	public static void main(String[] args) throws Exception {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		List<String> list2 = new ArrayList<String>();
		list2.add("a");
		// 使用反射向list1中添加整型 list2.add("abc");
		list2.getClass().getMethod("add", Object.class).invoke(list1, "张开");
		System.out.println(list1.get(1));
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		System.out.println("=========================");
		
		Type[] types = GenericTest.class.getMethod("applyGeneric", Vector.class).getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType)types[0];
		System.out.println(pType.getActualTypeArguments()[0]);
		System.out.println(pType.getRawType());
		System.out.println(pType.getOwnerType());
		System.out.println(pType.getTypeName());
	}
	
	public static void applyGeneric(Vector<Date> v) {
		
	}

}
