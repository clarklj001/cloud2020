package com.clarklj001.springcloud.commons;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号灯，通行证。线程阻塞，到得到一个通行证才能继续使用
 * 
 * 限制线程上限， 限流的时候用
 * 
 * @author jlong
 *
 */
public class SemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {

		int count = 3;
		Semaphore semaphore = new Semaphore(count);

		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "==> Caught thread.....");
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getName() + "==> Release thread.....");
					semaphore.release();
				}
			}, String.valueOf(i)).start();
		}
	}

}
