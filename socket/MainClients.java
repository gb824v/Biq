package com.att.biq.day26.networking.socket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainClients
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
			ClientWorker worker = new ClientWorker();
			executor.execute(worker);
		}
		executor.shutdown(); // When all workers finished, shutdown
		while (!executor.isTerminated())
		{
		}
		System.out.println("Done !!!");
	}
}