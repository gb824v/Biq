package com.att.biq.day7.abstruct;

import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for (String s : args)
		{
			switch (s)
			{
			case "D":
				animals.add(new Dog());
				break;
			case "C":
				animals.add(new Cat());
				break;
			case "W":
				animals.add(new Wolf());
				break;
			default:
				break;
			}
		}

		for (Animal animal : animals)
		{
			animal.makeSound();
		}

	}
}
