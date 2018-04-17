package com.att.biq.day23.threads;

public class MainPrintNum
{
	static public synchronized void printNumbers()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.print(Thread.currentThread().getId());
			System.out.println(":" + i);
		}
	}

	static public void main(String[] args)
	{
		System.out.println("Main ThreadId: " + Thread.currentThread().getId());

		for (int i = 0; i < 3; i++)
		{
			Thread myThread = new Thread(new Thread1());
			// myThread.setDaemon(true);
			// setDaemon = live till the mail live when the printNumbers of the
			// main completed all "demon threads" are dead.
			myThread.start();
		}
		printNumbers();
	}
}
