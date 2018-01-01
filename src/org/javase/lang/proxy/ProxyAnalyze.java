package org.javase.lang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 使用代理生成通用方法，返回需要的代理类和附加的系统功能
 * 
 * @author kevin
 *
 */
public class ProxyAnalyze {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Collection<String> proxyClass = (Collection<String>)getProxy(new ArrayList<String>(),new MyAdvice());
		proxyClass.add("1");
		proxyClass.size();
	}

	private static Object getProxy(final Object target, final Advice advice) {
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object var1, Method method, Object[] args) throws Throwable {
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;
					}
				});
		return proxy;
	}
	
}
