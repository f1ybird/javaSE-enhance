package org.javase.lang.proxy.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * bean工厂
 * 
 * @author kevin
 *
 */
public class BeanFactory {

	Properties pros = new Properties();

	public BeanFactory(InputStream is) {
		try {
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String name) {
		String className = pros.getProperty(name);
		Object bean = null;
		try {
			bean = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (bean instanceof ProxyFactoryBean) {
			Object proxy = null;
			ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;
			try {
				Advice advice = (Advice) Class.forName(pros.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(pros.getProperty(name + ".target")).newInstance();
				proxyFactoryBean.setAdvice(advice);
				proxyFactoryBean.setTarget(target);
				proxy = proxyFactoryBean.getProxy();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return proxy;
		}
		return bean;
	}

}
