package org.javase.lang.proxy;

import java.lang.reflect.Method;

public interface Advice {
	
	public void beforeMethod(Method method);

	public void afterMethod(Method method);
}
