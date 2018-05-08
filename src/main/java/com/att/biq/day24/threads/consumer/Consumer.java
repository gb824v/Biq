package com.att.biq.day24.threads.consumer;

public class Consumer implements Runnable
{
	Drop drop;

	public Consumer(Drop drop)
	{
		this.drop = drop;
	}
	@Override
	public void run()
	{
		String msg = "";
		while (!msg.equals("stop"))
		{
			try
			{
				msg = drop.pop();
				Thread.sleep(1000);
				System.out.println("Consumer get msg: " + msg);

			}
			catch (InterruptedException e)
			{
			}
		}
	}
}