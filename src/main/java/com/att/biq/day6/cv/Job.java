package com.att.biq.day6.cv;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Job
{

	String name;
	Date startDate;
	Date endDate;

	public Job(String name, Date startDate, Date endDate)
	{
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public boolean isBetween(Date year)
	{

		Calendar a = getCalendar(startDate);
		Calendar b = getCalendar(endDate);
		Calendar c = getCalendar(year);

		return (c.get(Calendar.DAY_OF_YEAR) > a.get(Calendar.DAY_OF_YEAR)
				&& c.get(Calendar.DAY_OF_YEAR) < b.get(Calendar.DAY_OF_YEAR));
		
	}

	public static Calendar getCalendar(Date date)
	{
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}
}
