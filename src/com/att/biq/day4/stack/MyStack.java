package com.att.biq.day4.stack;

public class MyStack<T>
{
	private T[] stackArray;
	private int top = -1;
	private int size = 0;

	public MyStack(int size)
	{
		this.size = size;
		stackArray = (T[]) new Object[size];
	}

	public void push(T j)
	{
		stackArray[++top] = j;
	}

	public T pop()
	{
		return stackArray[top--];
	}

	public T peek()
	{
		return stackArray[top];
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull()
	{
		return (top == size - 1);
	}

}