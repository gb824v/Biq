package com.att.biq.day23.threads.myatomicvar;


public class DecThread  implements Runnable {
	AtomicVar var;

	public DecThread(AtomicVar var)
	{
		this.var = var;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			var.dec();
			System.out.println("DecThread: " + var.getCount());
		}
	}
}
