package com.att.biq.day10.hascode;

import java.util.HashMap;

public class Main
{
	public static void main(String[] args)
	{
		HashMap<Person, Integer> hashMap = new HashMap<Person, Integer>();
		hashMap.put(new Person("Guy"), 5);
		hashMap.put(new Person("Ilan"), 65);
		hashMap.put(new Person("Doron"), 58);
		hashMap.put(new Person("Amir"), 58);

		System.out.println(hashMap.get(new Person("Guy")));
		System.out.println(hashMap.get(new Person("Amir")));
	}
}
