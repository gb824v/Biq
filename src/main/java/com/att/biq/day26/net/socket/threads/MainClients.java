package com.att.biq.day26.net.socket.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MainClients
{
	private static int numOfThreads = 5;


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