package com.att.biq.day9.expression;

public class Main
{
	public static void main(String[] args)
	{
		Sum sum = new Sum(new Number(2.0), new Number(3.0));
		Exponent exponent = new Exponent(new Number(2.0), new Number(3.0));
		Expression xpression = new Sum(sum, exponent);
		System.out.println(xpression + "=" + xpression.evaluate());
	}
}
