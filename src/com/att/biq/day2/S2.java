package com.att.biq.day2;

//Exceptions handling

public class S2
{

	public static void main(String[] args)
	{
		int[] primeArr = { -2, 9, 0, 22, 7, 11, 2, 1 };

		for (int num : primeArr)
		{
			try
			{
				System.out.println(isPrime(num) ? num + " is prime number" : num + " is not prime number");
			}
			catch (ArithmeticException ae)
			{
				System.err.println(num + ae.getMessage());
			}

		}
	}

	public static boolean isPrime(int number) throws ArithmeticException
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
}
