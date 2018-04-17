package com.att.biq.day23.threads.myatomicvar;


public class Main
{
	static public void main(String[] args) throws InterruptedException
	{
		//Should be 0
		AtomicVar atomic = new AtomicVar();
		Thread incThread = new Thread(new IncThread(atomic));	
		Thread decThread = new Thread(new DecThread(atomic));
		incThread.start();
		decThread.start();
		incThread.join();
		decThread.join();
		System.out.println(atomic.getCount());
	}
}
