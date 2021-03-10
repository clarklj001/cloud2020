package com.clarklj001.springcloud.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class TestLock1 {

	public static void main(String[] args) {
		Phone phone = new Phone();
		
		Collections.synchronizedList(new ArrayList<>());
		
		new Thread(() -> {
			phone.sendSms();
		}, "A").start();
//
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
		new Thread(() -> {
			phone.call();
		}, "B").start();
	}
}

class Phone {

	// synchronized 锁的对象是方法的调用者
	
	public synchronized void sendSms() {
		System.out.println("sendSms");
	}

	public synchronized void call() {
		System.out.println("call");
	}
}