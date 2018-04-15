package com.att.biq.day1;


public class S1
{
	public static void main(String[] args)
	{
		for (String s : args)
		{
			try
			{
				Integer.parseInt(s);

				if (s.contains("7"))
				{
					System.out.print(s + " ");
				}
			}
			catch (Exception e)
			{
			}
		}

	}

}