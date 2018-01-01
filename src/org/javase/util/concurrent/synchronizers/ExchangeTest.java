package org.javase.util.concurrent.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchange同步工具类测试
 * 
 * 类似于毒品交易，A拿着毒品到达了交易地点，等待B的到来，当B到达交易点后，A用毒品换回了B的money，B用money换回来A的毒品，到达了数据交换的目的

pool-1-thread-1正在把毒品交换出去
pool-1-thread-2正在把money交换出去
pool-1-thread-1换回的数据为：money
pool-1-thread-2换回的数据为：毒品

 * @author kevin
 *
 */
public class ExchangeTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Exchanger<String> exchanger = new Exchanger<String>();
		Runnable runnable1 = new Runnable(){
			public void run() {
				String data = "毒品";
				try {
					System.out.println(Thread.currentThread().getName() + "正在把" + data + "交换出去");
					Thread.sleep((long) (Math.random()*1000));
					System.out.println(Thread.currentThread().getName() + "换回的数据为：" + exchanger.exchange(data));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		threadPool.execute(runnable1);
		
		Runnable runnable2 = new Runnable(){
			public void run() {
				String data = "money";
				try {
					System.out.println(Thread.currentThread().getName() + "正在把" + data + "交换出去");
					Thread.sleep((long) (Math.random()*1000));
					System.out.println(Thread.currentThread().getName() + "换回的数据为：" + exchanger.exchange(data));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		threadPool.execute(runnable2);
	}
}
