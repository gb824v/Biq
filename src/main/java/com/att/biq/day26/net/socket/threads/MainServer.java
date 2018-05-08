package com.att.biq.day26.net.socket.threads;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer
{
	private static int numOfThreads = 10;

	static public void main(String[] args) throws Exception
	{
		ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
		ServerSocket server = new ServerSocket(7000);
		for (int i = 0; i < numOfThreads; i++)
		{
			ServerConsumer consumer = new ServerConsumer(server);
			executor.execute(consumer);
		}
		executor.shutdown(); // When all workers finished, shutdown
		while (!executor.isTerminated())
		{
		}
		System.out.println("Done !!!");
	}
}