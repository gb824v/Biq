package com.att.biq.day26.java8.exam.streams.parallel;


import java.util.ArrayList;
import java.util.List;

public class ParallelMain {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 10_000 ; i++) {
            items.add("Item " + i);
        }
        
        //sequential stream
//        items.stream().forEach((s) -> System.out.println(s));
        
        //parallel stream
//        items.parallelStream().forEach((s) -> System.out.println(s));
        
        //another way of making a stream parallel
        items.stream().parallel().forEach((s) -> System.out.println(s));
    }
}
