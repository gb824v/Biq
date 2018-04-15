package com.att.biq.day10.iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		LinkedList<Person> linkedlist = new LinkedList<Person>();
		linkedlist.add(new Person("Guy"));
		linkedlist.add(new Person("Ilan"));
		linkedlist.add(new Person("Doron"));
		linkedlist.add(new Person("Doron"));
		linkedlist.add(new Person("Amir"));

		Iterator<Person> it = linkedlist.iterator();

		while (it.hasNext())
		{
			Person p = it.next();
			if (p.getName().equals("Doron"))
			{
				it.remove();
			}
		}

		Iterator<Person> it2 = linkedlist.iterator();

		while (it2.hasNext())
		{
			System.out.println(it2.next());
		}
	}

}
