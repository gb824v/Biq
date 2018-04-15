package com.att.biq.day24.threads.blockingstack;

public class Consumer implements Runnable
{
	BlockingStack<String> bs;

	public Consumer(BlockingStack<String> bs)
	{
		this.bs = bs;
	}

	@Override
	public void run()
	{
		String msg = "";
		while (!msg.equals("stop"))
		{
			try
			{
				msg = bs.pop();
				Thread.sleep(1000);
				System.out.println("Consumer get msg: " + msg);
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}