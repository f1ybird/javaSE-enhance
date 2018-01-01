package org.javase.util.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition进行互斥
 * 使用Lock进行同步
 * 
 * @author kevin
 *
 */
public class ConditionTest {

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

class Business {

	private boolean bShouldsub = true;
	Lock lock = new ReentrantLock();
	Condition conditon = lock.newCondition();

	public void sub(int i) {
		lock.lock();
		try {
			while (!bShouldsub) {
				try {
					conditon.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 10; j++) {
				System.out.println("sub thread of " + j + "loop of " + i);
			}
			bShouldsub = false;
			conditon.signal();
		} finally {
			lock.unlock();
		}
	}

	public void main(int i) {
		lock.lock();
		try {
			while (bShouldsub) {
				try {
					conditon.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 1; j <= 100; j++) {
				System.out.println("main thread of " + j + "loop of " + i);
			}
			bShouldsub = true;
			conditon.signal();
		}finally {
			lock.unlock();
		}
	}
}
