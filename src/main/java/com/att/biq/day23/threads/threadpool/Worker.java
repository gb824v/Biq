package com.att.biq.day23.threads.threadpool;

public class Worker implements Runnable
{
	@Override
	public void run()
	{
		MainPrintNum.printNumbers();
	}
}
