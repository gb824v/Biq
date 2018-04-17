package com.att.biq.day23.threads.myatomic;

public class AtomicVar {
	private int c = 0;

	public synchronized void inc() {
			c++;
		}
	public synchronized void dec() {
			c--;
	}
	public synchronized int getCount() {
			return c;
		}
}
