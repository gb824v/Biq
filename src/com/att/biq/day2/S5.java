package com.att.biq.day2;

import java.util.Arrays;

public class S5
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(args));
		int[] frequencies = calcCharFrequncy(args);
		printBarChart(frequencies);
	}

	private static int[] calcCharFrequncy(String[] args)
	{
		int[] frequncies = new int['Z' - 'A' + 1];
		for (String s : args)
		{
			for (int i = 0; i < s.length(); ++i)
			{
				char theChar = Character.toUpperCase(s.charAt(i));
				if (theChar >= 'A' && theChar <= 'Z')
				{
					frequncies[theChar - 'A']++;
				}
			}
		}
		return frequncies;
	}

	private static void printBarChart(int[] frequencies)
	{
		for (int i = 0; i < frequencies.length; ++i)
		{
			if (frequencies[i] > 0)
			{
				System.out.print((char) ('A' + i) + " ");
				for (int j = 0; j < frequencies[i]; ++j)
				{
					System.out.print('#');
				}
				System.out.println();
			}
		}

	}

}
