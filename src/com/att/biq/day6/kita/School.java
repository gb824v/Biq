package com.att.biq.day6.kita;

import java.util.ArrayList;
import java.util.HashMap;

public class School
{

	private int schoolId;
	private ArrayList<Student> students = new ArrayList<Student>();

	public School(int schoolId)
	{
		this.schoolId = schoolId;
	}

	ArrayList<Student> getStudentsByKita(String kita)
	{
		ArrayList<Student> studentsByKita = new ArrayList<Student>();
		for (Student s : students)
		{
			if (s.getKita().equals(kita))
				studentsByKita.add(s);
		}

		return studentsByKita;

	}

	HashMap<String, ArrayList<Student>> getAllStudentsByKita()
	{
		HashMap<String, ArrayList<Student>> allStudentsByKita = new HashMap<String, ArrayList<Student>>();

		for (Student s : students)
		{
			ArrayList<Student> studentsList = allStudentsByKita.get(s.getKita());
			if (studentsList == null)
			{
				studentsList = new ArrayList<Student>();
				allStudentsByKita.put(s.getKita(), studentsList);
			}
			studentsList.add(s);
		}
		return allStudentsByKita;

	}

	void addStudent(String name, String kita)
	{
		Student student = new Student(name, kita);
		students.add(student);
	}

	public int getSchoolId()
	{
		return schoolId;
	}

	public void setSchoolId(int schoolId)
	{
		this.schoolId = schoolId;
	}

	public ArrayList<Student> getStudents()
	{
		return students;
	}

}
