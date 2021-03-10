package com.clarklj001.springcloud.commons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 加法计数器 允许一组线程全部等待达到共同障碍点的同步辅助
 * 
 * @author jlong
 *
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) throws InterruptedException {

		int count = 7;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
			System.out.println(Thread.currentThread().getName() + "==> All subtasks done!");
		});

		for (int i = 0; i < count; i++) {
			final int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "==> done subtask " + temp);

				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}

	}

}
