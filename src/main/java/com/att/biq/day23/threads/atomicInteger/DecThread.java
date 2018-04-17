package com.att.biq.day23.threads.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class DecThread implements Runnable {
	AtomicInteger var;

	public DecThread(AtomicInteger var) {
		this.var = var;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("DecThread: " + var.decrementAndGet());
		}
	}
}
