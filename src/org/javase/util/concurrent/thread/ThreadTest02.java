package org.javase.util.concurrent.thread;

/**
 * ֹͣ�̵߳ķ���
 * 1.ʹ�ñ�ʶ
 * 2.ʹ��stop
 * 3.interrupt
 * @author kevin
 *
 */
public class ThreadTest02 extends Thread{
	
	private volatile boolean exit = false; // �߳��˳���ʶ
	
    public static void main(String[] args) throws Exception 
    { 
    	ThreadTest02 thread = new ThreadTest02(); 
        thread.start(); 
        sleep(1000); // ���߳��ӳ�5�� 
        thread.join(); 
        System.out.println("�߳��˳�!"); 
    } 
	
	public static void main1(String[] args) {
		ThreadTest02 thread = new ThreadTest02() {
			@Override
			public void run() {
				// �߳�����
				while(true) {
					try {
						System.out.println("1 " + Thread.currentThread().getName());
						Thread.sleep(1000);
						//thread.exit = true;
						System.out.println("�߳��˳�");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
}
