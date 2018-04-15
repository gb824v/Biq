package com.att.biq.day3.employee;

import java.util.Date;

//Object Oriented

public class Person implements Comparable<Person>
{
	private String name = "";
	private Date birthDate = new Date();

	public Person(String name, Date birthDate)
	{
		this(name);
		this.birthDate = birthDate;
	}

	public Person(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Name: " + this.name + " Date:" + this.birthDate.toString();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	@Override
	public int compareTo(Person person)
	{
		return getName().compareTo(person.getName());
	}

}
