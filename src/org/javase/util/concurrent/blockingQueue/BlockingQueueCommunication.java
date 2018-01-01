package org.javase.util.concurrent.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 同步互斥，通知 使用阻塞队列实现
 * 子线程走10次，主线程走100次，这样循环50次
 * @author kevin
 *
 */
public class BlockingQueueCommunication {

	public static void main(String[] args) {
		Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 50; i++) {
					business.sub(i);
				}
			}
		}).start();
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}
	}

}

@SuppressWarnings("unchecked")
class Business {
	@SuppressWarnings("rawtypes")
	ArrayBlockingQueue queue1 = new ArrayBlockingQueue(1);
	@SuppressWarnings("rawtypes")
	ArrayBlockingQueue queue2 = new ArrayBlockingQueue(1);
	
	/**
	 * 匿名构造方法，运行在构造方法之前
	 */
	{
		try {
			queue2.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sub(int i) {
		try {
			queue1.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread of " + j + "loop of " + i);
		}
		try {
			queue2.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void main(int i) {
		try {
			queue2.put(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int j = 1; j <= 100; j++) {
			System.out.println("main thread of " + j + "loop of " + i);
		}
		
		try {
			queue1.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
