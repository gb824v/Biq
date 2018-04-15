package com.att.biq.day9.expression;

public class Number implements Expression
{
	double num;

	public Number(double num)
	{
		this.num = num;
	}

	@Override
	public double evaluate()
	{
		return num;
	}

	@Override
	public String toString()
	{
		return num + "";
	}

}
