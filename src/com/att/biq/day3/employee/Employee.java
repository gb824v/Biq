package com.att.biq.day3.employee;

public class Employee extends Person
{

	private Employee manager;

	public Employee(String name, Employee manager)
	{
		super(name);
		this.manager = manager;
	}

	@Override
	public String toString()
	{
		return super.toString() + (manager!=null? " ,reporting to: " + manager : " - I'm the big boss!");
		
	}
}
