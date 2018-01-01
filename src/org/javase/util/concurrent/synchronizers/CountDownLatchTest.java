package org.javase.util.concurrent.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时同步阻塞类测试 

类似于跑到上有三个运动员等待裁判发布命令，收到命令后，三个运动员到达到终点后，裁判员回应三个运动员的成绩

pool-1-thread-2准备接收命令
pool-1-thread-3准备接收命令
pool-1-thread-1准备接收命令
main即将发布命令
main已经发布命令，等待处理结果
pool-1-thread-2已经收到命令
pool-1-thread-1已经收到命令
pool-1-thread-3已经收到命令
pool-1-thread-3回应命令处理结果
pool-1-thread-2回应命令处理结果
pool-1-thread-1回应命令处理结果
main已经收到所结果

 * @author kevin
 *
 */
public class CountDownLatchTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CountDownLatch cdOrder = new CountDownLatch(1);
		CountDownLatch cdAnwser = new CountDownLatch(3);
		for(int i = 0;i < 3;i ++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						
						System.out.println(Thread.currentThread().getName() + "准备接收命令");
						cdOrder.await();
						System.out.println(Thread.currentThread().getName() + "已经收到命令");
						Thread.sleep((long) (Math.random() * 1000));
						System.out.println(Thread.currentThread().getName() + "回应命令处理结果");
						cdAnwser.countDown();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(runnable);
		}
		
		try {
			Thread.sleep((long) (Math.random() * 1000));
			System.out.println(Thread.currentThread().getName() + "即将发布命令");
			cdOrder.countDown();
			System.out.println(Thread.currentThread().getName() + "已经发布命令，等待处理结果");
			cdAnwser.await();
			System.out.println(Thread.currentThread().getName() + "已经收到所结果");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
