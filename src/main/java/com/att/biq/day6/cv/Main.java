package com.att.biq.day6.cv;

import java.util.ArrayList;
import java.util.Date;

public class Main
{
	public static void main(String[] args)
	{
		CV cv = new CV();
		cv.addJob("sdad", new Date(), new Date());
		ArrayList<Job> jobsBetween = cv.getListOfJobsBetween(new Date());
	}

}