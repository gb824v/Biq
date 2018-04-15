package com.att.biq.day5.enums_1;

public enum Operation
{
	PLUS, MINUS, TIMES, DIVIDE;

	double calculate(double x, double y)
	{
		switch (this)
		{
		case PLUS:
			return x + y;
		case MINUS:
			return x - y;
		case TIMES:
			return x * y;
		case DIVIDE:
			return x / y;
		default:
			throw new AssertionError("Unknown operations " + this);
		}
	}

	boolean isMeth(double x, double y, double c)
	{
		switch (this)
		{
		case PLUS:
			return calculate(x ,y) == c;
		case MINUS:
			return calculate(x ,y) == c;
		case TIMES:
			return calculate(x ,y) == c;
		case DIVIDE:
			return calculate(x ,y) == c;
		default:
			throw new AssertionError("Unknown operations " + this);
		}
	}

}