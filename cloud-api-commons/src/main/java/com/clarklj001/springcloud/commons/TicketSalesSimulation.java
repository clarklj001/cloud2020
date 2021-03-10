package com.clarklj001.springcloud.commons;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSalesSimulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		
		
		Ticket ticket = new Ticket();

		new Thread(() -> {
			for(int i=0; i<40; i++) {
				ticket.sale();
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<40; i++) {
				ticket.sale();
			}
		}).start();
		new Thread(() -> {
			for(int i=0; i<40; i++) {
				ticket.sale();
			}
		}).start();

	}
}

class Ticket {

	private int number = 30;

	public synchronized void sale() {
		if (number > 0) {
			System.out.println(Thread.currentThread().getName() + ": Saling the " + number + " ticket and " + (--number)
					+ " remain.");
		}
	}

}
