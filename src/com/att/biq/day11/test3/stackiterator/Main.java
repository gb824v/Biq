package com.att.biq.day11.test3.stackiterator;

public class Main
{
	public static void main(String[] args) throws FullStackException, EmptyStackException
	{
		MyStack myStack = new MyStack(100);
		myStack.push(45);
		myStack.push(46);
		myStack.push(47);
		for (int i:myStack)
		{
			System.out.println(i);
		}
	}
}
