package org.javase.util.concurrent.thread;

/**
 * Thread����ʵ�ֶ��߳�
 * @author kevin
 *
 */
public class ThreadTest01 {
	public static void main(String[] args) {
		Thread thread01 = new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println("1  "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread01.start();
		
		Thread thread02 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println("2  "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread02.start();
		
		// new Thread(){}.start();
		new Thread(
				new Runnable() {
					@Override
					public void run() {
						while(true) {
							try {
								Thread.sleep(1000);
								System.out.println("inner  "+Thread.currentThread().getName());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}) {
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						System.out.println("outer  "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}}.start();
		}
}
