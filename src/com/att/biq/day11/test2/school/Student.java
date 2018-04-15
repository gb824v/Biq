package com.att.biq.day11.test2.school;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person
{
	private Map<Integer, Course> coursesGradeMap = new HashMap<Integer, Course>();

	public Student(String name, int id, String email)
	{
		super(name, id, email);
	}

	public Map<Integer, Course> getCoursesGradeMap()
	{
		return coursesGradeMap;
	}

	public void setCoursesGradeMap(Map<Integer, Course> coursesGradeMap)
	{
		this.coursesGradeMap = coursesGradeMap;
	}

}
