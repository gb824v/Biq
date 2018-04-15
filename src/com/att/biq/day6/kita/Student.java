package com.att.biq.day6.kita;

public class Student
{

	String name;
	String kita;

	public Student(String name, String kita)
	{
		this.name = name;
		this.kita = kita;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getKita()
	{
		return kita;
	}

	public void setKita(String kita)
	{
		this.kita = kita;
	}
}
