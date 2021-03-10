package com.clarklj001.springcloud.commons;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 只能一个线程写，可以多个线程读
 * 
 * @author jlong
 *
 */
public class ReadWriteLockDemo {
	public static void main(String[] args) throws InterruptedException {

//		MyCache myCache = new MyCache();
		MyCacheLock myCache = new MyCacheLock();

		for (int i = 1; i <= 5; i++) {
			final int temp = i;
			new Thread(() -> {
				myCache.put(temp + "", temp + "");
			}, String.valueOf(i)).start();
		}
		for (int i = 1; i <= 5; i++) {
			final int temp = i;
			new Thread(() -> {
				myCache.get(temp + "");
			}, String.valueOf(i)).start();
		}

	}

}

class MyCache {
	private volatile Map<String, Object> map = new HashMap<>();

	public void put(String key, Object value) {
		System.out.println(Thread.currentThread().getName() + " writes " + key);
		map.put(key, value);
		System.out.println(Thread.currentThread().getName() + " writes OK");
	}

	public void get(String key) {
		System.out.println(Thread.currentThread().getName() + " reads " + key);
		map.get(key);
		System.out.println(Thread.currentThread().getName() + " reads ok");
	}

}

class MyCacheLock {
	private volatile Map<String, Object> map = new HashMap<>();

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	// 写入的时候，只希望同时只有一个线程写
	public void put(String key, Object value) {
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " writes " + key);
			map.put(key, value);
			System.out.println(Thread.currentThread().getName() + " writes OK");
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	public void get(String key) {
		
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " reads " + key);
			map.get(key);
			System.out.println(Thread.currentThread().getName() + " reads ok");
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

}
