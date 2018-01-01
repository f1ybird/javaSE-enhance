package org.javase.util.concurrent.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kevin
 *
 */
public class SynchronizedTest {
	public static void main(String[] args) {
		Output output = new SynchronizedTest().init();
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
	
	static class Output {
		public static void print(String name) {
			synchronized(Output.class) {
				int len = name.length();
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
	
}
