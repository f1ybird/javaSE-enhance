package org.javase.lang.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/**
 * 代理测试类：通过代理获取Collection的构造方法和方法以及使用代理创造Collection实例对象
 * 
 * @author kevin
 *
 */
public class ProxyTest {
	
	@SuppressWarnings({ "rawtypes"})
	public static void main(String[] args) {
		Class<?> proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), new Class[] {Collection.class});
		System.out.println("proxyClass:" + proxyClass.getName());// com.sun.proxy.$Proxy0
		
		/**
		 * 通过代理类获取Collection的构造方法
		 */
		System.out.println("begin constructors list ===================");
		Constructor[] constructors = proxyClass.getConstructors();
		for (Constructor constructor : constructors) {
			StringBuilder sb = new StringBuilder(constructor.getName()).append("(");;
			Class[] parameterTypes = constructor.getParameterTypes();
			for (Class parameterType : parameterTypes) {
				sb.append(parameterType.getName()).append(",");
			}
			if(parameterTypes.length != 0 && parameterTypes != null) {
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(")");
			System.out.println(sb);
		}
	
		/**
		 * 通过代理类获取Collection的方法
		 */
		System.out.println("begin methods list ===================");
		Method[] methods = proxyClass.getMethods();
		for (Method method : methods) {
			StringBuilder sb2 = new StringBuilder(method.getName()).append("(");;
			Class[] parameterTypes = method.getParameterTypes();
			for (Class parameterType : parameterTypes) {
				sb2.append(parameterType.getName()).append(",");
			}
			if(parameterTypes.length != 0 && parameterTypes != null) {
				sb2.deleteCharAt(sb2.length() - 1);
			}
			sb2.append(")");
			System.out.println(sb2);
		}
		
		/**
		 * 使用代理创造Collection实例对象
		 */
		try {
			Collection collection = (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(),
					new Class[] { Collection.class }, new InvocationHandler() {
						@Override
						public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
							return "hello";
						}
					});
			System.out.println(collection.toString());;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
