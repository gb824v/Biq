package com.att.biq.day9.expression;

public class Sum extends ExpressionBase
{

	public Sum(Expression exp1, Expression exp2)
	{
		super(exp1, exp2);
	}

	@Override
	public double evaluate()
	{
		return exp1.evaluate() + exp2.evaluate();
	}
	@Override
	public String toString()
	{
		return "(" + exp1 + "+ " + exp2 + ")";
	}
}
