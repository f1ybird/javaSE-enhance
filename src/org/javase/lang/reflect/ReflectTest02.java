package org.javase.lang.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

public class ReflectTest02 {
	
	/**
	 * 通过读取配置文件，创建类（写框架基础）
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// 资源文件的加载
		// 方式1：文件流读取
		// InputStream is = new FileInputStream("config/reflect.properties");
		
		// 方式2：类加载器加载
		// InputStream is = Reflect01.class.getResourceAsStream("reflect.properties");// 放到classPath目录下
		
		InputStream is = Reflect01.class.getClassLoader().getResourceAsStream("config/reflect.properties");// 放到classPath目录下
		
		Properties pros = new Properties();
		pros.load(is);
		is.close();
		//String listName = pros.getProperty("listName");// java.util.ArrayList
		//Collection<Reflect01> collection = (Collection<Reflect01>)Class.forName(listName).newInstance();
		String setName = pros.getProperty("setName");// java.util.HashSet
		Collection<Reflect01> collection = (Collection<Reflect01>)Class.forName(setName).newInstance();
		Reflect01 r1 = new Reflect01();
		Reflect01 r2 = new Reflect01();
		Reflect01 r3 = new Reflect01(2);
		collection.add(r1);
		collection.add(r2);
		collection.add(r3);
		collection.add(r1);
		System.out.println(collection.size());
	}
	
	/**
	 * 比较ArrayList和HashSet的区别：HashSet底层通过hashCode进行了位置检索，所以在遍历的同时修改集合元素会造成ConcurrentModifiedException
	 * @param args
	 */
	public static void main1(String[] args) {
//		Collection<Reflect01> collection = new ArrayList<Reflect01>();
		// HashSet底层使用的hashCode对存储的元素进行检索，当存储的元素的hashCode值一致时就会判断为同一个位置，所以不会重复存储
		Collection<Reflect01> collection = new HashSet<Reflect01>();
		Reflect01 r1 = new Reflect01();
		Reflect01 r2 = new Reflect01();
		Reflect01 r3 = new Reflect01(2);
		collection.add(r1);
		collection.add(r2);
		collection.add(r3);
		collection.add(r1);
		
		// 对hashSet中的元素进行修改后，再对集合中的元素进行操作就无法找到原来的元素，因为修改后hashCode值变化了，这样也就造成了内存泄漏
		r3.x = 22;
		
		collection.remove(r3);
		
		System.out.println(collection.size());
	}

}
