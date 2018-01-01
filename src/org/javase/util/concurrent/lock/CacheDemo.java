package org.javase.util.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁自定义模拟缓存设计
 * 
 * @author kevin
 *
 */
public class CacheDemo {

	public static void main(String[] args) {
	}
	
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	Lock rl = rwl.readLock();
	Lock wl = rwl.writeLock();
	Map<Integer, String> map =  new HashMap<Integer, String>();
	public String getData(Integer key) {
		rl.lock();
		String value = "";
		try {
			value = map.get(key);
			if(null == value) {
				rl.unlock();
				wl.lock();
				try {
					if(null == value) {
						value = "data";// 缓存业务
					}
				} finally {
					wl.unlock();
				}
				rl.lock();
			}
		} finally {
			rl.unlock();
		}
		return value;
	}
}

