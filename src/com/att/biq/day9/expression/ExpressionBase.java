package com.att.biq.day9.expression;

public abstract class ExpressionBase implements Expression
{
	protected Expression exp1;
	protected Expression exp2;

	public ExpressionBase(Expression exp1, Expression exp2)
	{
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}
