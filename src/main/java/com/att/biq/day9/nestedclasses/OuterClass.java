package com.att.biq.day9.nestedclasses;

public class OuterClass
{
	private int a;
	
	// InnerStaticClass/ can't access to a;
	static public class InnerStaticClass
	{
		public int b;
	}

	public class InnerClass 
	{
		int b;
		public void setA(int a1)
		{
			a = a1;
		}
		public InnerClass(int b)
		{
			this.b = b;
		}
	}
}
