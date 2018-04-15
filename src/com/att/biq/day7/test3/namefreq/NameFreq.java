package com.att.biq.day7.test3.namefreq;

import java.util.ArrayList;
import java.util.HashMap;

public class NameFreq
{
	public static void main(String[] args)
	{
		ArrayList<HashMap<String, Integer>> allYears = new ArrayList<HashMap<String, Integer>>();
		HashMap<String, Integer> year = new HashMap<String, Integer>();

		year.put("Guy", 100);
		year.put("Doron", 104);
		allYears.add(year);
		year.put("Guy", 100);
		year.put("Doron", 104);
		allYears.add(year);
		year.put("Ilan", 105);
		year.put("Niv", 102);
		allYears.add(year);
		allYearsTogther(allYears);

	}

	private static void allYearsTogther(ArrayList<HashMap<String, Integer>> allYears)
	{
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();

		for (HashMap<String, Integer> year : allYears)
		{
			for (String key : year.keySet())
			{
				if (nameMap.get(key) == null)
				{
					nameMap.put(key, year.get(key));
				}
				else
				{
					int sum = nameMap.get(key) + year.get(key);
					nameMap.put(key, sum);
				}
			}
		}
		System.out.println("AllYears: " + nameMap);
	}
}
