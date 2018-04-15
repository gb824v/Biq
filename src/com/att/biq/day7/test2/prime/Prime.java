package com.att.biq.day7.test2.prime;

public class Prime
{
	public static void main(String[] args)
	{
		for (String s : args)
		{
			try
			{
				int num = Integer.parseInt(s);
				if (istPrime(num) && !s.isEmpty())
				{
					System.out.println(s + " is prime number");
				}
				else
				{
					System.err.println(s + " is not prime number");
				}

			}
			catch (Exception e)
			{
				System.err.println(s + " is not number");
			}
		}
	}

	public static boolean istPrime(int num)
	{
		if (num % 2 == 0)
		{
			return false;
		}
		for (int i = 3; i * i < num; i += 2)
		{
			if (num % i == 0)
				return false;
		}
		return true;
	}
}