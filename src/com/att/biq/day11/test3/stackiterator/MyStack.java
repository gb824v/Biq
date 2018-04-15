package com.att.biq.day11.test3.stackiterator;

public class MyStack implements Iterable<Integer>
{
	private int[] stackArray;
	protected int top = -1;
	private int size = 0;
	
	
	
	
	public MyStack(int size)
	{
		this.size = size;
		stackArray = new int[size];
	}

	public void push(int j) throws FullStackException
	{
		if (isFull())
		{
			throw new FullStackException("The stack is full");

		}
		else
		{
			stackArray[++top] = j;
		}
	}

	public int pop() throws EmptyStackException
	{
		int j = 0;
		if (!isEmpty())
		{
			j = stackArray[top--];
		}
		else
		{
			throw new EmptyStackException("The stack is empty");
		}

		return j;
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull()
	{
		return (top == size - 1);
	}

	public int getTop()
	{
		return top;
	}

	@Override
	public StackIterator iterator()
	{
		return new StackIterator(stackArray,top);
	}

}