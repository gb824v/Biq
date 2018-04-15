package com.att.biq.day10.hascode;

//Hash code need to implement when we want to use person as key
// need to implement hashCode (to find the bucket in the list) and equal to find person in the hashmap   

public class Person implements Comparable<Person>
{
	private String name = "";

	public Person(String name, int id)
	{
		this(name);
	}

	public Person(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Person && ((Person) o).name.equals(name));
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int compareTo(Person person)
	{
		return getName().compareTo(person.getName());
	}

}
