package org.javase.util.concurrent.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore同步工具测试
 * 
 * @author kevin
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName() + "进入，当前还剩" + (3 - semaphore.availablePermits()) + "个线程");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep((long)Math.random()*10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "即将离开");
					semaphore.release();
					System.out.println(Thread.currentThread().getName() + "已经离开，当前有" + (3 - semaphore.availablePermits()) + "个线程并发");
				}
			};
			threadPool.execute(runnable);
		}
	}
}
