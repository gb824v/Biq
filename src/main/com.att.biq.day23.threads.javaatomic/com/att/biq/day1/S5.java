package com.att.biq.day1;

public class S5
{

	public static void main(String[] args)
	{
		int sum = 0;
		double len = 0;
		len = args.length;
		for (String i : args)
		{
			try
			{
				sum += Integer.parseInt(i);
				System.out.println(i);
			}
			catch (Exception e)
			{
				len--;
			}

		}
		System.out.println(avg(len, sum));
	}

	public static double avg(double len, int sum)
	{
		double avg;
		avg = sum / len;
		return avg;
	}
}
