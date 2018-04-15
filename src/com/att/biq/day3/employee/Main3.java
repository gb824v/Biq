package com.att.biq.day3.employee;

public class Main3
{
	public static void main(String[] args)
	{
		Employee employee = new Employee("Guy Bitan", new Employee("Ilan Miler", new Employee("Doron Niv", null)));
		System.out.println(employee);

	}
}
