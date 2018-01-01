package org.javase.util.concurrent.question;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 现成程序中的Test类中的代码在不断地产生数据，然后交给TestDo.doSome()方法去处理，
 * 就好像生产者在不断地产生数据，消费者在不断消费数据。请将程序改造成有10个线程来消费生成者产生的数据，
 * 这些消费者都调用TestDo.doSome()方法去进行处理，故每个消费者都需要一秒才能处理完，
 * 程序应保证这些消费者线程依次有序地消费数据，只有上一个消费者消费完后，下一个消费者才能消费数据，
 * 下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。原始代码如下：
 * 
 * @author kevin
 *
 */
public class Question02 {

	public static void main(String[] args) {
		SynchronousQueue<String> queue = new SynchronousQueue<String>();
		Semaphore semaphore = new Semaphore(1); // 实现每秒只有一个线程执行任务
		//Lock lock = new ReentrantLock();      // 实现每秒只有一个线程执行任务
		for(int i=0;i<10;i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
						//lock.lock();
						String output = TestDoSomething.doSome(queue.take());
						System.out.println(Thread.currentThread().getName() + ":" + output);
						//lock.unlock();
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		for (int i = 0; i < 10; i++) { // 这行不能改动
			String input = i + ""; // 这行不能改动
			try {
				queue.put(input);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 不能改动此TestDo类
class TestDoSomething {
	public static String doSome(String input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}