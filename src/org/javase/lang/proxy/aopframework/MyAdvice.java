package org.javase.lang.proxy.aopframework;

import java.lang.reflect.Method;

/**
 * AOP 自定义通知类
 * 
 * @author kevin
 *
 */
public class MyAdvice implements Advice {

	long beginTime = 0;
	
	@Override
	public void beforeMethod(Method method){
		beginTime = System.currentTimeMillis();
		System.out.println("开始啦");
	}

	@Override
	public void afterMethod(Method method) {
		System.out.println("结束啦");
		System.out.println(method.getName());
	}

}
