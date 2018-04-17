package com.att.biq.day1;

public class S3
{
	String s = "Hello";

	private void foo(String s)
	{
		s += " World";
		System.out.println(s);
	}

	public static void main(String[] args)
	{
		S3 obj = new S3();
		String s = "Guy";
		obj.foo(s);
	}

}
