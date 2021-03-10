package com.clarklj001.springcloud.commons;

import java.util.concurrent.CountDownLatch;

/**
 * 等待其他线程的任务执行完成，再执行
 * 按照时间顺序严格执行一些任务时使用
 * 
 * @author jlong
 *
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {

		int count = 10;
		CountDownLatch countDownLatch = new CountDownLatch(count);

		for (int i = 0; i < count; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "==> Go out");
				countDownLatch.countDown();
			}, String.valueOf(i)).start();
		}

		//等待计数器归零，然后再向下执行
		countDownLatch.await();
		
		System.out.println("all out");
	}

}
