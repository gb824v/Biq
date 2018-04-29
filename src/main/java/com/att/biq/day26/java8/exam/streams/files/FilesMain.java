package com.att.biq.day26.java8.exam.streams.files;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesMain {
	public static void main(String[] args) throws IOException {
		
		// List Files
//		try (Stream<Path> stream = Files.list(Paths.get("/"))) {
//		    String joined = stream
//		        .map(String::valueOf)
//		        .filter(path -> !path.startsWith("."))
//		        .sorted()
//		        .collect(Collectors.joining("; "));
//		    System.out.println("List: " + joined);
//		}
		
		// Finding Files
//		Path start = Paths.get(".");
//		int maxDepth = 5;
//		try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
//		        String.valueOf(path).endsWith(".java"))) {
//		    String joined = stream
//		        .sorted()
//		        .map(Path::getFileName)
//		        .map(String::valueOf)
//		        .collect(Collectors.joining("; "));
//		    System.out.println("Found: " + joined);
//		}

		// Reading Files
		try (Stream<String> stream = Files.lines(Paths.get("/Users/blechl/Downloads/AT&T/Presentations/Java8/Examples/examples/streams/files/FilesMain.java"))) {
		    stream.forEach(System.out::println);
		}
	}
}
