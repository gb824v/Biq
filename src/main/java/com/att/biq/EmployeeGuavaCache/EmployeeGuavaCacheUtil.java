package com.att.biq.EmployeeGuavaCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class EmployeeGuavaCacheUtil
{
	private static LoadingCache<Integer, Employee> empCache;

	static
	{
		empCache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<Integer, Employee>()
				{
					@Override
					public Employee load(Integer id) throws Exception
					{
						return getEmployeeById(id);
					}
				});
	}

	public static LoadingCache<Integer, Employee> getLoadingCache()
	{
		return empCache;
	}

	public static Employee getEmployeeById(int id)
	{
		System.out.println("--Executing getEmployeeById--");
		//Perform any expensive task like fetching data from Database.
		//For the demo we are performing a simple task
		Employee emp1 = new Employee(1, "Ramesh");
		Employee emp2 = new Employee(2, "Mohan");
		if (id == 1)
		{
			return emp1;
		}
		else
		{
			return emp2;
		}
	}
}

