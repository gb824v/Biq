package com.att.biq.day6.kita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main
{

	public static void main(String[] args)
	{
		School sc = new School(12345);
		sc.addStudent("Ilan", "A");
		sc.addStudent("GuyB", "B");
		sc.addStudent("Ilan", "A");
		sc.addStudent("GuyB", "B");

		ArrayList<Student> students = sc.getStudentsByKita("A");
		for (Student s : students)
		{
			System.out.println(s.getName());
		}
		HashMap<String, ArrayList<Student>> studentsArr = sc.getAllStudentsByKita();

		for (Entry<String, ArrayList<Student>> ent : studentsArr.entrySet())
		{
			for (Student s : ent.getValue())
			{
				System.out.println(s.getName() + " Kita:" + s.getKita());
			}
		}
	}

}
