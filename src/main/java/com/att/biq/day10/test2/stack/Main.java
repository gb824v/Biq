package com.att.biq.day10.test2.stack;

public class Main
{
	public static void main(String[] args) throws FullStackException, EmptyStackException
	{
		BetterStack myStack = new BetterStack(100);
		myStack.push(45);
		myStack.push(45);
		myStack.push(45);
		System.out.println(myStack.getCount());
		System.out.println(myStack.getEverage());
		System.out.println(myStack.getSum());
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println(myStack.getCount());
		System.out.println(myStack.getEverage());
		System.out.println(myStack.getSum());
	}
}
