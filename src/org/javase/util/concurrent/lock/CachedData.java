package org.javase.util.concurrent.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁模拟缓存系统
 * 
 * @author kevin
 *
 */
public class CachedData {
   Object data;
   volatile boolean cacheValid;
   final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

   void processCachedData() {
     rwl.readLock().lock();
     // 没有缓存，则释放读锁，然后加写锁
     if (!cacheValid) {
        // Must release read lock before acquiring write lock
        rwl.readLock().unlock();
        rwl.writeLock().lock();
        try {
          // Recheck state because another thread might have
          // acquired write lock and changed state before we did.
			if (!cacheValid) {
				// 缓存数据
				// data = ...
				cacheValid = true;
			}
          // Downgrade by acquiring read lock before releasing write lock
          rwl.readLock().lock();
        } finally {
          rwl.writeLock().unlock(); // Unlock write, still hold read
        }
     }

     try {
       // 使用缓存数据
       // use(data);
     } finally {
       rwl.readLock().unlock();
     }
   }
 }