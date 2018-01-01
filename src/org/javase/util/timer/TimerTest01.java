package org.javase.util.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器测试类
 * 
 * @author kevin
 *
 */
public class TimerTest01 {

	private static int count = 0;
	public static void main(String[] args) {
//		new Timer().schedule(new TimerTask() {
//			public void run() {
//				System.out.println("bombing!");
//			}}, 1000);
		
		System.out.println(new Date().getSeconds());
//		new Timer().schedule(new TimerTask() {
//			public void run() {
//				System.out.println(new Date().getSeconds());
//				System.out.println("bombing!");
//			}}, 3000,1000);
		
		class myTimerTask extends TimerTask{
			public void run() {
				System.out.println(new Date().getSeconds());
				count = (count + 1) % 2;
				System.out.println("bombing!");
				new Timer().schedule(new myTimerTask(), 2000+2000*count);
			}
		}
		new Timer().schedule(new myTimerTask(), 2000);
	}
}
