package org.javase.util.concurrent.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger 提供原子操作来进行Integer的使用，因此十分适合高并发情况下的使用。在线程安全的情况下执行整型的加或减等数值运算	
 * @author kevin
 *
 */
public class AtomicIntegerTest {
	public static void main(String[] args) {
		AtomicInteger atomic = new AtomicInteger();
		atomic.set(4);
//		atomic.incrementAndGet();// +1 = 1
//		atomic.addAndGet(2);// +2 = 3 
//		atomic.get();//获取当前的数
//		atomic.decrementAndGet();// -1
//		atomic.accumulateAndGet(n, intBinaryOperator)
//		atomic.doubleValue();// return the value as double
		
//		boolean bool = atomic.compareAndSet(5, 3);
//		System.out.println(bool);
//		System.out.println(atomic.get());
//		boolean bool = atomic.weakCompareAndSet(4, 5);
//		System.out.println(bool);
//		System.out.println(atomic.get());
		
//		atomic.lazySet(5);
//		System.out.println(atomic.get());
//		atomic.incrementAndGet();
//		System.out.println(atomic.get());
//		System.out.println(atomic.addAndGet(2));
	}
}
