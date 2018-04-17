package com.att.biq.day13.recursion;

public class Main
{
	public static void main(String[] args)
	{
		// System.out.println(factorial(5));
		// System.out.println(fibonacci(5));
		// System.out.println(fibonacciLoop(5));
		// System.out.println(exponentiation(5, 10));
		System.out.println(p("abcdcdcba".toCharArray(), 0, "abcdcdcba".length() - 1));
		System.out.println(search(new int[]{5,66,89}, 3, 67));
	}

	// Azeret 6!
	public static int factorial(int n)
	{
		int num = n;
		if (n != 2)
		{
			num = num * factorial(n - 1);
		}
		return num;
	}

	public static long fibonacci(int i)
	{
		if (i == 0)
			return 0;
		if (i <= 2)
			return 1;

		long fibTerm = fibonacci(i - 1) + fibonacci(i - 2);
		return fibTerm;
	}

	public static int fibonacciLoop(int n)
	{
		int prev = 0, next = 1, result = 0;

		for (int i = 0; i < n; i++)
		{
			result = prev + next;
			prev = next;
			next = result;
		}
		return result;
	}

	public void descending(int n)
	{
		if (n <= 0)
		{
			return;
		}
		System.out.println(n);
		descending(n - 1);
	}

	// Hezka 2^3
	public static int exponentiation(int x, int m)
	{
		if (m == 0)
		{
			return 1;
		}
		else if (m == 1)
		{
			return x;
		}
		return x * exponentiation(x, m - 1);
	}
	//if "abcdcdcba" is polinom                 
	public static boolean p(char[] c, int i, int f)
	{
		if (i < f)
		{
			if (c[i] == c[f])
			{
				return p(c, i + 1, f - 1);
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}

	public static boolean search(int[] x, int size, int n)
	{
		if (size > 0)
		{
			if (x[size - 1] == n)
			{
				return true;
			}
			else
			{
				return search(x, size - 1, n);
			}
		}
		return false;
	}
}
