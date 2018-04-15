package com.att.biq.day4.stack;

public class Main
{
	public static void main(String[] args)
	{
		MyStack<String> s = new MyStack<String>(3);
		s.push("1");
		s.push("2");
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
