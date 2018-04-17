package com.att.biq.day23.threads.atomicvar;

import java.util.concurrent.atomic.AtomicInteger;

public class IncThread implements Runnable {
	AtomicInteger var;

	public IncThread(AtomicInteger var) {
		this.var = var;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("IncThread: " + var.incrementAndGet());
		}
	}
}
