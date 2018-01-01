package org.javase.util.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevin
 *
 */
public class LockTest {
	public static void main(String[] args) {
		Output output = new LockTest().init();
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				while(true) {
					try {
						Thread.sleep(200);
						output.print("====zhangkai");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();;
		
		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				while(true) {
					try {
						
						Thread.sleep(200);
						output.print("====wangyi");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();;
	}
	
	public Output init() {
		return new Output();
	}
	
	/**
	 * 使用lock🔒进行同步互斥
	 * @author kevin
	 *
	 */
	static class Output {
		
		static Lock lock = new ReentrantLock();
		
		public static void print(String name) {
			lock.lock();
			int len = name.length();
			try {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			} finally {
				lock.unlock();
			}
		}
	}
	
}
