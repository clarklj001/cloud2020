package com.clarklj001.springcloud.commons;

import java.util.concurrent.TimeUnit;

public class TestLock2 {

	public static void main(String[] args) {
		Phone2 phone = new Phone2();
		Phone2 phone2 = new Phone2();
		
		new Thread(() -> {
			phone.sendSms();
		}, "A").start();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			phone2.call();
		}, "B").start();
		
	}
}

class Phone2 {

	// synchronized 锁的对象是方法的调用者
	
	public synchronized void sendSms() {
		
		System.out.println("sendSms");
	}

	public synchronized void call() {
		System.out.println("call");
	}
	
}