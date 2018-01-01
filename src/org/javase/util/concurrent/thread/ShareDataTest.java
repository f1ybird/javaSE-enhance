package org.javase.util.concurrent.thread;

/**
 * 多个线程共享一份变量
 * 
 * @author kevin
 *
 */
public class ShareDataTest {

	public static void main(String[] args) {
		ShareData data = new ShareData();
		new Thread(new MyRunnable1(data)).start();
		new Thread(new MyRunnable2(data)).start();
	}
	
}

class MyRunnable1 implements Runnable {
	ShareData data = new ShareData();
	public MyRunnable1(ShareData data) {
		this.data = data;
	}
	public void run() {
		while(true)
			data.increment();
	}
}

class MyRunnable2 implements Runnable {
	ShareData data = new ShareData();
	public MyRunnable2(ShareData data) {
		this.data = data;
	}
	public void run() {
		while(true)
			data.decrement();
	}
}

class ShareData {

	@SuppressWarnings("unused")
	private int ticket = 100;
	
	public void increment() {
		ticket ++;
	}
	
	public void decrement() {
		ticket --;
	}
	
}