package com.att.biq.day11.test2.school;

import java.util.ArrayList;

public class CourseInstances
{
	Course course;
	int year = 0;
	int instanceId = 0;
	Term term;
	Teacher teacher;
	ArrayList<Student> studentList = new ArrayList<Student>();

	public CourseInstances(Course course, int year, int instanceId, Term term, Teacher teacher)
	{
		this.course = course;
		this.year = year;
		this.instanceId = instanceId;
		this.term = term;
		this.teacher = teacher;
	}

	public void add(Student s)
	{
		studentList.add(s);
	}

	public ArrayList<Student> getStudentList()
	{
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList)
	{
		this.studentList = studentList;
	}
	
}
