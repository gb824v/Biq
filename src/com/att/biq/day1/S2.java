package com.att.biq.day1;

public class S2
{
	private void foo(int i)
	{
		i = 10;
	}
	
	private void foo(Integer ii)
	{
		
	}
	public static void main(String[] args)
	{
		S2 a = new S2();
		int i = 10;
		a.foo(i);
		System.out.println(i);
		Integer ii = 99;
		a.foo(ii);
		System.out.println(ii);
	}

}
