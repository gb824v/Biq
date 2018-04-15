package com.att.biq.day10.test2.stack;

public class BetterStack extends MyStack
{
	private int sum = 0;

	public BetterStack(int capacity)
	{
		super(capacity);
	}

	protected int getSum() throws EmptyStackException
	{
		return sum;
	}

	public double getEverage() throws EmptyStackException
	{
		return (double) sum / getCount();
	}

	public void push(int j) throws FullStackException
	{
		try
		{
			super.push(j);
			sum += j;
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

	}

	public int pop() throws EmptyStackException
	{
		int j=0;
		try
		{
			j=super.pop();
			sum -= j;
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return j;
	}

	public int getCount()
	{
		return top + 1;
	}
}