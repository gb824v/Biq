package com.att.biq.day23.threads;

public class Thread1 implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("Thread ThreadId: " + Thread.currentThread().getId());
		MainPrintNum.printNumbers();
	}
}
