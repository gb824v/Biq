package com.att.biq.EmployeeGuavaCache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class EmployeeGuavaCacheUtil {
    public static LoadingCache empCache;

    static {
        CacheLoader cacheLoader = new CacheLoader<Integer, Employee>() {
            @Override
            public Employee load(Integer id) throws Exception {
                return new Employee(1, "Guy");
            }
        };
        //Expire entries after the specified duration has passed since the entry was created,
        //or the most recent replacement of the value.
        //This could be desirable if cached data grows stale after a certain amount of time
        empCache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(1, TimeUnit.MICROSECONDS)
                .build(cacheLoader);
    }
}

