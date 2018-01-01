package org.javase.lang.proxy.aopframework;

public class Test {
	
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory(Test.class.getClassLoader().getResourceAsStream("config/aop.properties"));
		Object bean = beanFactory.getBean("xx");
		System.out.println(bean.getClass().getName());;// 生成普通javaBean 结果 java.util.ArrayList
		
		Object bean2 = beanFactory.getBean("xxx");
		System.out.println(bean2.getClass().getName());;// 生成代理  结果  com.sun.proxy.$Proxy0
	}

}
