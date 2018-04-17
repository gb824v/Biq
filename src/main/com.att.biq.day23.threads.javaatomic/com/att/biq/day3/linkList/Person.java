package com.att.biq.day3.linkList;

//Object Oriented

public class Person implements Comparable<Person>
{
	private String name = "";
	private Integer id = 0;

	public Person(String name, int id)
	{
		this(name);
		this.id = id;
	}

	public Person(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return this.name + "[" + id + "]";
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public int compareTo(Person person)
	{
		return getName().compareTo(person.getName());
	}

}
