package com.att.biq.day23.threads.myatomicvar;

public class IncThread implements Runnable
{
	AtomicVar var;

	public IncThread(AtomicVar var)
	{
		this.var = var;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			var.inc();
			System.out.println("IncThread: " + var.getCount());
		}
	}
}
