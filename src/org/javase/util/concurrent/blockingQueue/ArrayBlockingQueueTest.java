package org.javase.util.concurrent.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列测试类
 * 
 * @author kevin
 *
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@SuppressWarnings("unchecked")
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "准备放数据");
						Thread.sleep((long) (Math.random()*1000));
						queue.put(1);
						System.out.println(Thread.currentThread().getName() + "放完了，队列现在有" + queue.size() + "个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "准备拿数据");
						Thread.sleep(1000);
						queue.take();
						System.out.println(Thread.currentThread().getName() + "拿完了，队列现在有" + queue.size() + "个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
}
