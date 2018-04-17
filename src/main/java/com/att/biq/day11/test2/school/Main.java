package com.att.biq.day11.test2.school;

public class Main
{
	public static void main(String[] args)
	{

		School s = new School();
		ApplyOnStudet applyOnStudent = new ApplyOnStudet()
		{
			@Override
			public void applyFunction(Student s)
			{
				Email.sendMail(s.getEmail());

			}
		};
		Course course = new Course("A", 123);
		Teacher teacher = new Teacher("Amir", 100, "amir.k@gmail.com");
		CourseInstances courseInstance = new CourseInstances(course, 2017, 19876, Term.A, teacher);
		s.forAllStudetsInCourse(courseInstance, applyOnStudent);
	}
}