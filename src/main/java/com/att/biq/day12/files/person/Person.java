package com.att.biq.day12.files.person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Person implements Comparable<Person>, Serializable
{
	private static final long serialVersionUID = -1488243818170571187L;

	private String name = "";
	private Date birthDate = new Date();
	private String fileName = "c:\\file.txt";

	public Person(String name, Date birthDate)
	{
		this.name = name;
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
	public void save()
	{
		try
		{
			ObjectOutputStream dataOut = new ObjectOutputStream(new FileOutputStream(fileName));
			dataOut.writeObject(this);
			dataOut.close();
		}
		catch (Exception e)
		{
		}
	}
	public Person read()
	{
		Person mapInFile = null;
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			mapInFile = (Person) ois.readObject();
			ois.close();
		}
		catch (Exception e)
		{
		}
		return mapInFile;
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

}
