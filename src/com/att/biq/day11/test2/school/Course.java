package com.att.biq.day11.test2.school;

public class Course
{
	private String name;
	private int number;

	public Course(String name, int number)
	{
		super();
		this.name = name;
		this.number = number;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

}
