package com.att.biq.day26.java8.liran.examples.lambda.traversing;

import java.util.ArrayList;
import java.util.List;

public class TraversingMain {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");

		// Traverse with for:each
		for (String str : strings) {
			System.out.println(str);
		}

//		strings.forEach((str) -> {
//			System.out.println(str);
//		});

		// strings.forEach((str) -> System.out.println(str));

		// strings.forEach(str -> System.out.println(str));

		// strings.forEach(System.out::println);
	}
}