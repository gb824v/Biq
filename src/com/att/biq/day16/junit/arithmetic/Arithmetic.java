package com.att.biq.day16.junit.arithmetic;

public class Arithmetic
{
	public boolean isPrime(int number) throws ArithmeticException
	{
		if (number == 0)
		{
			throw new ArithmeticException(" is zero !!!");
		}

		else if (number < 0)
		{
			throw new ArithmeticException(" is negetiv !!!");
		}
		else if (number == 1)
		{
			return false;
		}
		for (int i = 2; i <= number / 2; i++)
		{
			if (number % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	// Azeret 6!
	public int factorial(int n)
	{
		int num = n;
		if (n != 2)
		{
			num = num * factorial(n - 1);
		}
		return num;
	}

	public long fibonacci(int i)
	{
		if (i == 0)
			return 0;
		if (i <= 2)
			return 1;

		long fibTerm = fibonacci(i - 1) + fibonacci(i - 2);
		return fibTerm;
	}
}
