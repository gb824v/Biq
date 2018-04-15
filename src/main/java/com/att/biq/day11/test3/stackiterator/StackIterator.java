package com.att.biq.day11.test3.stackiterator;

import java.util.Iterator;

public class StackIterator implements Iterator<Integer>
{

	int[] stackArray;
	private int index;

	public StackIterator(int[] stackArray, int top)
	{
		this.stackArray = stackArray;
		index = top;
	}

	@Override
	public boolean hasNext()
	{
		if (index > -1)
		{
			return stackArray[index] != 0;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Integer next()
	{
		return stackArray[index--];
	}

}
