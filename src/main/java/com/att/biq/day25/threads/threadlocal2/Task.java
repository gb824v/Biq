package com.att.biq.day25.threads.threadlocal2;

import java.util.Date;

class Task implements Runnable
{
	@Override
	public void run()
	{
		for (int i = 0; i < 2; i++)
		{
			String threadName = "Thread: " + Thread.currentThread().getName();
			String safeFormated = ThreadLocalTest.threadSafeFormat(new Date());
			System.out.println(threadName + " Formatted Date: " + safeFormated);
		}
	}
}
