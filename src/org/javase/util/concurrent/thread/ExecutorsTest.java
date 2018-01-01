package org.javase.util.concurrent.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Excutors框架测试
 * 
 * 1.创建线程池：固定池，单池，缓冲池
 * 2.关闭线程池
 * 3.使用线程池启动定时器 ==> 固定时间按照固定的频率执行任务
 * @author kevin
 *
 */
public class ExecutorsTest {
	
	/**
	 * CompletionService执行一组runnable任务
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
		for (int i = 0; i < 10; i++) {
			int seq = i;
			completionService.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					return seq;
				}
			});
		}
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(completionService.take().get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main3(String[] args) {
		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
		// 3秒后执行任务
		/*threadPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("bomming");
			}
		}, 3, TimeUnit.SECONDS);*/
		
		// 2秒后第一次执行任务，以后每3秒执行一次任务
		threadPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("bomming");
			}
		}, 2, 3, TimeUnit.SECONDS);
//		threadPool.shutdown();
	}
	
	// Callable和Future threadPool.submit();
	public static void main1(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
//		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(new Callable<String>() {
			public String call() throws Exception {
				return "hello world";
			}
		});
		
		try {
			System.out.println("拿到的数据：" + future.get().toString());
			threadPool.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	// 启动线程池 threadPool.execute();
	public static void main2(String[] args) {
//		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int j = 0;j < 10; j++) {
			final int take = j;
			threadPool.execute(new Runnable() {
				public void run() {
					for (int i = 0; i <=10; i++) {
						try {
							Thread.sleep(1000);
							System.out.println(Thread.currentThread().getName() + " is loop of  " + i + "  take  " + take);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			
		}
		threadPool.shutdown();
	}
}
