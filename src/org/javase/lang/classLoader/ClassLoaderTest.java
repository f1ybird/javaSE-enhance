package org.javase.lang.classLoader;

import java.util.Date;

import org.javase.lang.classLoader.ClassLoaderAttachment;

/**
 * classLoader测试类
 * 
 * @author kevin
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader);
			loader = loader.getParent();
		}
		
		System.out.println(new ClassLoaderAttachment());
		
		Class<?> clazz = new MyClassLoader("mylib").loadClass("ClassLoaderAttachment");
		Date c = (Date)clazz.newInstance();
		System.out.println(c.toString());
	}

}
