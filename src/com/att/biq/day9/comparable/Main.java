package com.att.biq.day9.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Person> persons = new ArrayList<>();
		Person person = new Person("Guy", 55);
		persons.add(person);
		person = new Person("Guy", 45);
		persons.add(person);
		Collections.sort(persons);
		System.out.println(persons);
	}
}
