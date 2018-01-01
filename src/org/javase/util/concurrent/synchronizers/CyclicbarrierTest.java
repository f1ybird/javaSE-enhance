package org.javase.util.concurrent.synchronizers;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 循环等待阻塞测试类
 * 
只有当三个线程都到达1个集合点后才会一起向下继续执行
pool-1-thread-1到达集合点1，当前已有1个人齐了，继续走啊
pool-1-thread-3到达集合点1，当前已有2个人齐了，继续走啊
pool-1-thread-2到达集合点1，当前已有3个人齐了，继续走啊

pool-1-thread-2到达集合点2，当前已有1个人齐了，继续走啊
pool-1-thread-1到达集合点2，当前已有2个人齐了，继续走啊
pool-1-thread-3到达集合点2，当前已有3个人齐了，继续走啊

pool-1-thread-3到达集合点3，当前已有1个人齐了，继续走啊
pool-1-thread-2到达集合点3，当前已有2个人齐了，继续走啊
pool-1-thread-1到达集合点3，当前已有3个人齐了，继续走啊

 * @author kevin
 *
 */
public class CyclicbarrierTest {
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(Thread.currentThread().getName() + "到达集合点1，当前已有" + (cyclicBarrier.getNumberWaiting() + 1) + "个人齐了，继续走啊");
						cyclicBarrier.await();
						
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(Thread.currentThread().getName() + "到达集合点2，当前已有" + (cyclicBarrier.getNumberWaiting() + 1) + "个人齐了，继续走啊");
						cyclicBarrier.await();
						
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println(Thread.currentThread().getName() + "到达集合点3，当前已有" + (cyclicBarrier.getNumberWaiting() + 1) + "个人齐了，继续走啊");
						cyclicBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(runnable);
		}
	}

}
