package com.att.biq.day24.threads.consumer;

public class Drop
{
	private String message = null;
	private boolean isEmpty = true;

	public synchronized String pop()
	{
		// Wait if string is empty
		while (isEmpty)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
			}

		}
		isEmpty = true;
		// notifyAll -> In this point the other thread still wait until we will
		// exist from the synchronized {} block
		notifyAll();
		return message;
	}

	public synchronized void push(String message)
	{
		// Wait if string is full
		while (!isEmpty)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
			}
		}
		isEmpty = false;
		this.message = message;
		// notifyAll -> In this point the other thread still wait until we will
	   // exist from the synchronized {} block
		notifyAll();
	}
}
