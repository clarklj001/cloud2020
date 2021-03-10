package com.clarklj001.springcloud.commons;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSalesSimulationWithLock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Ticket2 ticket = new Ticket2();

		new Thread(() -> {
			for (int i = 0; i < 40; i++) {
				ticket.sale();
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 40; i++) {
				ticket.sale();
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 40; i++) {
				ticket.sale();
			}
		}).start();

	}
}

class Ticket2 {

	private int number = 30;
	Lock lock = new ReentrantLock();

	public void sale() {

		lock.lock();
		try {
			if (number > 0) {
				System.out.println(Thread.currentThread().getName() + ": Saling the " + number + " ticket and "
						+ (--number) + " remain.");
			}
		} finally {
			lock.unlock();
		}

	}

}

