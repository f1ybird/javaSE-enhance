package org.javase.util.concurrent.thread;

import java.util.Random;

/**
 * 
 * 
 * @author kevin
 *
 */
public class ThreadLocalTest01 {

//	private static ThreadLocal<Integer> x= new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + ":" + data);
//					x.set(data);
					ThreadScopeData.getThreadInstance().setName(data);
					ThreadScopeData.getThreadInstance().setAge(data);
					new A().get();
				}
			}).start();
		}
	}

	static class A {
		public  void get() {
//			int data = x.get();
//			System.out.println("A " + Thread.currentThread().getName() + ":" + data);
			ThreadScopeData scopeData = ThreadScopeData.getThreadInstance();
			System.out.println("A " + Thread.currentThread().getName() + ":name-" + scopeData.getName()+"-age-"+scopeData.getAge());
		}
	}

}

/**
 * ����ģʽ֮����ģʽ
 * 
 * @author kevin
 *
 */
class ThreadScopeData {
	private static ThreadLocal<ThreadScopeData> map = new ThreadLocal<ThreadScopeData>();
	
	private ThreadScopeData() {
	}

	public static ThreadScopeData getThreadInstance() {
		ThreadScopeData instance = map.get();
		if (instance == null) {
			instance = new ThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	
	private int name;
	private int age;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}