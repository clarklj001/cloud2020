package com.clarklj001.springcloud.commons;

import java.util.concurrent.TimeUnit;

public class TestLock3 {

	public static void main(String[] args) {
		Phone3 phone = new Phone3();
		Phone3 phone2 = new Phone3();
		
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

class Phone3 {

	// 静态方法 synchronized 锁的对象是类
	
	public static synchronized void sendSms() {
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("sendSms");
	}

	public static synchronized void call() {
		System.out.println("call");
	}
	
}