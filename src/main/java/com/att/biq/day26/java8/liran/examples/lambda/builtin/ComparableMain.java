package com.att.biq.day26.java8.liran.examples.lambda.builtin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparableMain {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("EEE");

		System.out.println("Simple sort:");
		Collections.sort(strings); // String built in sort acknowledges casing
		// Traverse with for:each
		for (String str : strings) {
			System.out.println(str);
		}

		System.out.println("Sort with comparator:");
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareToIgnoreCase(str2);
			}
		};
		Collections.sort(strings, comp);
		// Collections.sort(strings, (str1, str2) -> str1.compareToIgnoreCase(str2));

		for (String str : strings) {
			System.out.println(str);
		}
		// Another way to traverse - Traverse with iterator
		// Iterator<String> i = strings.iterator();
		// while (i.hasNext()) {
		// System.out.println(i.next());
		// }
	}
}