package org.javase.lang.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Properties;

/**
 * javaBean的内省操作
 * 使用反射创建javaBean的getter和setter方法和创建类
 * 
 * @author kevin
 *
 */
public class ReflectJavaBeanTest {
	
	/**
	 * 通过读取配置文件，创建类（写框架基础）
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void main1(String[] args) throws Exception {
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

	public static void main(String[] args) throws Exception{
		Reflect01 reflect01 = new Reflect01(3);
		
		String propertyName = "x";
		
		System.out.println("getVal1->" + getProperty(propertyName, reflect01));
		
		Object value = 33;
		setProperty(propertyName, reflect01, value);
		System.out.println("getVal2->" + getProperty(propertyName, reflect01));
		
		Object value2 = 66;
		setProperty2(propertyName, reflect01, value2);
		
		System.out.println("getVal3->" + getProperty(propertyName, reflect01));
	}

	private static Object getProperty(String propertyName, Object reflect01) throws Exception {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, reflect01.getClass());
		Method readMethodGetX = propertyDescriptor.getReadMethod();
		return readMethodGetX.invoke(reflect01);
	}

	/**
	 * set方法
	 * @param propertyName
	 * @param reflect01
	 * @param value
	 * @throws Exception
	 */
	private static void setProperty(String propertyName, Object reflect01, Object value) throws Exception {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, reflect01.getClass());
		Method writeMethodSetX = propertyDescriptor.getWriteMethod();
		writeMethodSetX.invoke(reflect01, value);
	}
	
	/**
	 * set方法2
	 * @param propertyName
	 * @param reflect01
	 * @param value
	 * @throws Exception
	 */
	private static void setProperty2(String propertyName, Object reflect01, Object value) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(reflect01.getClass());
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : descriptors) {
			if(propertyDescriptor.getName().equals(propertyName)) {
				Method writeMethodSetX = propertyDescriptor.getWriteMethod();
				writeMethodSetX.invoke(reflect01, value);
				break;
			}
		}
	}
}
