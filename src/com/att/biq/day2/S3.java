package com.att.biq.day2;
import java.util.Arrays;

//Varargs format

public class S3
{

	public static void main(String[] args)
	{
		print("bb", 9, 0, 22, 7, 11, 2, 1, "aaa", new int[] { 1, 2, 3 }, new String[] { "aa", "gg", "cc" });
	}

	private static void print(Object... args) throws ArithmeticException
	{
		for (Object o : args)
		{
			if (o instanceof Object[])
			{
				System.out.println(Arrays.deepToString((Object[]) o));
			}
			else if (o instanceof int[])
			{
				System.out.println(Arrays.toString((int[]) o));
			}
			else
			{
				System.out.println(o);
			}
		}
	}
}
