package org.javase.util.concurrent.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试类
 * 
 * @author kevin
 *
 */
public class ReadWriteLockTest {
	
	private static Queue queue = new Queue();
	private static Object data = new Object();
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					queue.put(data);
				}
			}).start();
		}
		
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					queue.get();
				}
			}).start();
		}
	}

	/**
	 * 读写锁封装类 
	 * 
	 * @author kevin
	 *
	 */
	static class Queue {
		
		private Object data = null; // 共享数据
		ReadWriteLock rwl = new ReentrantReadWriteLock();
		
		/**
		 * 读的时候上读锁，读写互斥，写写互斥
		 */
		public void get() {
			rwl.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " be ready read data");
				Thread.sleep((long) (Math.random() * 1000));
				System.out.println(Thread.currentThread().getName() + " have read data " + data);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rwl.readLock().unlock();
			}
		}
		
		/**
		 * 写的时候上写锁，读写互斥，写写互斥
		 * @param data
		 */
		public void put(Object data) {
			rwl.writeLock().lock();
			try {
				System.out.println(Thread.currentThread().getName() + " be ready write data");
				Thread.sleep((long) (Math.random() * 1000));
				this.data = data;
				System.out.println(Thread.currentThread().getName() + " have write data " + data);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rwl.writeLock().unlock();
			}
		}
	}
}
