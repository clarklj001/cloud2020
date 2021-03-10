package com.clarklj001.springcloud.commons;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {
	
	public static void main(String[] args) {
		
		int maximumPoolSize = Runtime.getRuntime().availableProcessors();
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, maximumPoolSize, 5, 
				TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), 
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
		
		try {
			for (int i = 1; i <= 20; i++) {
				executor.execute(()->{
					System.out.println(Thread.currentThread().getName()+ " ******");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
			
		} finally {
			executor.shutdown();
		}
	}

}
