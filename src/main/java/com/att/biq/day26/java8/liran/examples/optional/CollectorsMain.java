package com.att.biq.day26.java8.liran.examples.optional;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsMain {
	public static void main(String[] args) {
		
		List<String> beatles = Arrays.asList("john", "george", "paul", "ringo");

		// Collectors.toList()
		List<String> resultList = beatles.stream()
				  .collect(Collectors.toList());
		
		// Collectors.toSet()
		Set<String> resultSet = beatles.stream()
				  .collect(Collectors.toSet());
		
		// Collectors.toCollection()
		Collection<String> resultCollection = beatles.stream()
					.collect(Collectors.toCollection(LinkedList::new));
		
		// Collectors.toMap()
		Map<String, Integer> resultMap = beatles.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length));
		// Function.identity() is a utility function that accepts and return the same value
		
		// in case there might be a collision between the key values you can provide another BinaryOperator to handle collisions
		Map<String, Integer> resultMapWithCollisionResolving = beatles.stream()
				  .collect(Collectors.toMap(Function.identity(), String::length, (i1, i2) -> i1));
		
		// Collectors.joining()
		String resultString = beatles.stream()
				.collect(Collectors.joining());
		
		String resultStringWithCommas = beatles.stream()
				.collect(Collectors.joining(", "));
		
		String resultStringWithPrefixAndPostFix = beatles.stream()
				  .collect(Collectors.joining(" ", "PRE-The-Fab-Four: ", " -POST-TheBeatles"));
		
		// Statistics
		Random random = new Random();
		IntSummaryStatistics statistics = random.ints().limit(10).summaryStatistics();
		statistics.getAverage(); statistics.getCount(); statistics.getMax(); statistics.getMin(); statistics.getSum();
		
		// Collectors.groupingBy()
		Map<Integer, Set<String>> resultGroupBy = beatles.stream()
				  .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		
		// Collectors.partitioningBy() - like group by but for 2 values (boolean) only
		Map<Boolean, List<String>> resultPartitions = beatles.stream()
				  .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0));
		
	}
}
