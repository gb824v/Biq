package com.att.biq.day24.threads.blockingstack;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingStack<T>
{
	private Queue<T> blockingStack = new LinkedList<T>();
	private int size;

	public BlockingStack(int size)
	{
		this.size = size;
	}

	public synchronized void push(T t, int timeOut) throws InterruptedException
	{
		while (isFull())
		{
			wait(timeOut);
		}
		blockingStack.add(t);
		notifyAll();
	}

	public synchronized void push(T t) throws InterruptedException
	{
		push(t, 0);
	}

	public synchronized T pop() throws InterruptedException
	{
		return pop(0);
	}

	public synchronized T pop(int timeOut) throws InterruptedException
	{
		while (isEmpty())
		{
			wait(timeOut);
		}
		notifyAll();
		return blockingStack.poll();
	}

	private boolean isEmpty()
	{
		return blockingStack.isEmpty();
	}

	private boolean isFull()
	{
		return blockingStack.size() == size;
	}
}