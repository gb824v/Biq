package com.att.biq.day11.test2.school;

import java.util.ArrayList;

public final class School
{
	private ArrayList<CourseInstances> courseInstanceList = new ArrayList<CourseInstances>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

	public School(ArrayList<CourseInstances> courseInstanceList, ArrayList<Course> courseList,
			ArrayList<Student> studentList, ArrayList<Teacher> teacherList)
	{
		this.setCourseInstanceList(courseInstanceList);
		this.setCourseList(courseList);
		this.setStudentList(studentList);
		this.setTeacherList(teacherList);
	}
	public School()
	{
		
	}
	public void forAllStudetsInCourse(CourseInstances courseInstance,ApplyOnStudet apply)
	{
		
		for (Student studet : courseInstance.getStudentList())
		{
			apply.applyFunction(studet);
		}
	}

	public ArrayList<CourseInstances> getCourseInstanceList()
	{
		return courseInstanceList;
	}

	public void setCourseInstanceList(ArrayList<CourseInstances> courseInstanceList)
	{
		this.courseInstanceList = courseInstanceList;
	}

	public ArrayList<Course> getCourseList()
	{
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList)
	{
		this.courseList = courseList;
	}

	public ArrayList<Teacher> getTeacherList()
	{
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList)
	{
		this.teacherList = teacherList;
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
