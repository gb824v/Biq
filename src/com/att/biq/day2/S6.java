package com.att.biq.day2;

import java.util.Arrays;
import java.util.HashMap;

public class S6
{
	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(args));
		HashMap<String, Integer> frequenciesNames = calcNameFrequncy(args);
		printBarChart(frequenciesNames);
	}

	private static HashMap<String, Integer> calcNameFrequncy(String[] args)
	{
		HashMap<String, Integer> childs = new HashMap<>();
		for (String s : args)
		{
			if (!s.isEmpty())
			{
				if (childs.get(s) != null)
				{
					int count = childs.get(s) + 1;
					childs.put(s, count);
				}
				else
				{
					childs.put(s, 1);
				}

				for (int i = 0; i < s.length(); ++i)
				{
					char theChar = Character.toUpperCase(s.charAt(i));
					if (theChar >= 'A' && theChar <= 'Z')
					{
						String theCharStr = theChar + "";
						if (childs.get(theCharStr) != null)
						{
							int count = childs.get(theCharStr) + 1;
							childs.put(theCharStr, count);
						}
						else
						{
							childs.put(theCharStr, 1);
						}
					}
				}
			}
		}
		return childs;
	}

	private static void printBarChart(HashMap<String, Integer> frequencies)
	{
		for (String name : frequencies.keySet())
		{
			String key = name.toString();
			System.out.print(key + " [");
			int value = frequencies.get(name);
			for (int j = 0; j < value; ++j)
			{
				System.out.print('#');
			}
			System.out.println("] " + value);
		}

	}
}
