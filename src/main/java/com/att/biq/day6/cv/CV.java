package com.att.biq.day6.cv;

import java.util.ArrayList;
import java.util.Date;

public class CV
{

	ArrayList<Job> jobs = new ArrayList<Job>();

	public void addJob(String jobName, Date from, Date to)
	{
		jobs.add(new Job(jobName, from, to));
	}

	public ArrayList<Job> getListOfJobsBetween(Date year)
	{
		ArrayList<Job> jobsBetween = new ArrayList<Job>();

		for (Job job : jobs)
		{
			if (job.isBetween(year))
			{
				jobsBetween.add(job);
			}
		}
		return jobsBetween;
	}

}
