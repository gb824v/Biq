package com.att.biq.EmployeeGuavaCache;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
public class CacheDemo {
	public static void main(String[] args) {
		CacheDemo cacheDemo = new CacheDemo();
		try {
            System.out.println("CacheSize:" + EmployeeGuavaCacheUtil.empCache.size());
			System.out.println("Get-> " + ((Employee)EmployeeGuavaCacheUtil.empCache.get(1)).getName());
            Thread.sleep(1000);
            System.out.println("CacheSize:" + EmployeeGuavaCacheUtil.empCache.size());
            System.out.println("Get-> " + ((Employee)EmployeeGuavaCacheUtil.empCache.get(1)).getName());
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
