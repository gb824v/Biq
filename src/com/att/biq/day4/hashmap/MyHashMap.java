package com.att.biq.day4.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class MyHashMap
{
	public static void main(String[] args)
	{
		ArrayList<HashMap<String, Integer>> allYears = new ArrayList<HashMap<String, Integer>>();
		HashMap<String, Integer> year = new HashMap<String, Integer>();
		year.put("Guy", 100);
		year.put("Doron", 104);
		year.put("Ilan", 105);
		year.put("Niv", 102);
		year.put("Benny", 104);
		year.put("Avi", 106);
		year.put("Idit", 108);
		allYears.add(year);
		year.put("Guy", 100);
		year.put("Doron", 104);
		year.put("Ilan", 105);
		year.put("Niv", 102);
		year.put("Benny", 104);
		year.put("Avi", 106);
		year.put("Idit", 108);
		allYears.add(year);
		year.put("Guy", 100);
		year.put("Doron", 104);
		year.put("Ilan", 105);
		year.put("Niv", 102);
		year.put("Benny", 104);
		year.put("Avi", 106);
		year.put("Idit", 108);
		allYears.add(year);
		aggrigateAll(allYears);
		
		
		ArrayList<HashMap<Integer, Integer>> allYears1 = new ArrayList<HashMap<Integer, Integer>>();
		HashMap<Integer, Integer> year1 = new HashMap<Integer, Integer>();
		
		
		year1.put(77, 100);
		year1.put(6666, 104);
		year1.put(666666, 105);
		allYears1.add(year1);
		
		aggrigateAll(allYears1);
	}

	private static <T> void aggrigateAll(ArrayList<HashMap<T, Integer>> allYears)
	{
		HashMap<T, Integer> nameMap = new HashMap<T, Integer>();

		for (HashMap<T, Integer> year : allYears)
		{
			for (T key : year.keySet())
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
		System.out.println(nameMap);
	}
}
