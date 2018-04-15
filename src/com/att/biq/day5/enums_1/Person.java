package com.att.biq.day5.enums_1;

public class Person
{

	public static int count = 0;
	private String  name= "";
	
	public Person(String name)
	{
		this.name = name;
		count++;
	}
	public static int getCount()
	{
		return count;
	}
	public static void setCount(int count)
	{
		Person.count = count;
	}
	
	public static void main (String[]  args )
	{
		Person person = new Person("fdffds");
		person = new Person("fdffds");
		person = new Person("fdffds");
		
		System.out.println(Person.getCount());
	}
}
