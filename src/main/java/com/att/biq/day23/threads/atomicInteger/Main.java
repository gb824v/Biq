package com.att.biq.day23.threads.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Main
{
	static public void main(String[] args) throws InterruptedException
	{
		//Should be 0
		AtomicInteger  atomic = new AtomicInteger ();
		Thread incThread = new Thread(new IncThread(atomic));	
		Thread decThread = new Thread(new DecThread(atomic));
		incThread.start();
		decThread.start();
		incThread.join();
		decThread.join();
	}
}
