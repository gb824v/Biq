package com.att.biq.day25.threads.callable;

import io.reactivex.Observable;

public class MyObservable
{

	public static void main(String args[])
	{
		Observable<String> observer = Observable.just("Hello"); // provides datea
		final String[] result = { "" };
		observer.subscribe(s -> result[0] =s);  // Callable as subscriber
		System.out.println(result[0]);

	}
}