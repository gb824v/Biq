package com.att.biq.day9.nestedclasses;

public class Main
{
	public static void main(String[] args)
	{
		OuterClass.InnerStaticClass obj1 = new OuterClass.InnerStaticClass();
		OuterClass.InnerClass obj2 = new OuterClass().new InnerClass(5);
		obj2.setA(3);
		OuterClass obj3 =new OuterClass() ;
		obj2 = obj3.new InnerClass(7);
	}
}
