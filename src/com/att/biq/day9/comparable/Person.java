package com.att.biq.day9.comparable;

public class Person implements Comparable<Person>
{
	private String name = "";
	private int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age=age;
	}

	@Override
	public String toString()
	{
		return this.name + " Age: " + age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	// Compare age and name
	@Override
	public int compareTo(Person person)
	{
		// (if 0 = equal) got to next filed.
		int compareName = name.compareTo(person.getName());
		return compareName == 0 ? age - person.age : compareName;
	}
	

}
