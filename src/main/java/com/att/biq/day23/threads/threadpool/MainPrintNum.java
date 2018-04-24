package com.att.biq.day23.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPrintNum
{
	private static int numOfTasks = 5;
	private static int numOfThreads = 5;

	//All threads call this function
	static public synchronized void printNumbers()
	{
		for (int i = 0; i < numOfTasks; i++)
		{
			System.out.println("ThreadId:" + Thread.currentThread().getId() + " Task:" + i);
		}
	}

	static public void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);

		for (int i = 0; i < numOfThreads; i++)
		{
			Worker worker = new Worker();
			executor.execute(worker);
		}
		executor.shutdown(); // When all workers finished, shutdown
		while (!executor.isTerminated())
		{
		}
		System.out.println("Done !!!");
	}
}