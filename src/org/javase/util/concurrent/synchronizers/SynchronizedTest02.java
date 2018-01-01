package org.javase.util.concurrent.synchronizers;

/**
 * 同步互斥，通知 synchronized wait notify 实现
 * 子线程走10次，主线程走100次，这样循环50次
 * @author kevin
 *
 */
public class SynchronizedTest02 {

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
	
	public synchronized void sub(int i) {
		while(!bShouldsub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread of " + j + "loop of " + i);
		}
		bShouldsub = false;
		this.notify();
	}

	public synchronized void main(int i) {
		while(bShouldsub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("main thread of " + j + "loop of " + i);
		}
		bShouldsub = true;
		this.notify();
	}
}
