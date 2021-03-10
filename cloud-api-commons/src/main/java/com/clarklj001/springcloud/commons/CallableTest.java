package com.clarklj001.springcloud.commons;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		new Thread(new Runnable()).start();
//		new Thread(new FutureTask<V>()).start();
//		new Thread(new FutureTask<V>(Callable)).start();

		MyCallable myCallable = new MyCallable();
		FutureTask<String> futureTask = new FutureTask<String>(myCallable);
		new Thread(futureTask, "A").start();
		new Thread(futureTask, "B").start();// 只会调用一次 call(),这次不会调用

		//可能产生阻塞，需要等待call方法，或者使用异步来处理
		String string = futureTask.get();  

		System.out.println(string);
	}

}

class MyCallable implements Callable<String> {

	private int i = 1;
	
	@Override
	public String call() throws Exception {
		i++;
		System.out.println("callable" + i);
		return "call...return"+i;
	}
}
