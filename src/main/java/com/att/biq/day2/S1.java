package com.att.biq.day2;

//Exceptions handling

public class S1
{

	public static void main(String[] args)
	{
		double[][] dividerArr =
		{
				{ -2, 0.4},
				{ 9, 0 },
				{ 0, 0 },
				{ 16, 43 } };

		for (double[] dividers : dividerArr)
		{
			try
			{
				double results = paw(dividers[0], dividers[1]);
				System.out.println(results);
			}
			catch (ArithmeticException ae)
			{
				System.err.println(ae.getMessage());
			}

		}
	}

	public static double paw(double dividers, double dividers2) throws ArithmeticException
	{
		double results;
		results = Math.pow(dividers, dividers2);
		if (Double.isNaN(results) || Double.isInfinite(results))
		{
			throw new ArithmeticException("results is NaN/Infinite");
		}
		return results;
	}
}
