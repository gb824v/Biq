package com.att.biq.day9.expression;

public class Exponent extends ExpressionBase
{

	public Exponent(Expression exp1, Expression exp2)
	{
		super(exp1, exp2);
	}

	@Override
	public double evaluate()
	{
		return Math.pow(exp1.evaluate(), exp2.evaluate());
	}

	@Override
	public String toString()
	{
		return "(" + exp1 + "^" + exp2 + ")";
	}
}
