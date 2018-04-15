package com.att.biq.day11.test2.school;

public class Person implements Comparable<Person>
{
	private String name = "";
	private long id;
	private String email;

	public Person(String name, int id, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public int compareTo(Person person)
	{
		int compareName = name.compareTo(person.getName());
		int compareId = (int) (person.id - person.getId());
		return compareName == 0 ? compareId : compareName;
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Person && ((Person) o).id == this.id);
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return name + " " + id + "";
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
