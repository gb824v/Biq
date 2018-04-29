package com.att.biq.day26.java8.liran.examples.streams.parallel;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CountMain {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 10_000_000 ; i++) {
            items.add("Item " + i);
        }
        
        //count
        Instant start = Instant.now();
        long count = items.stream().parallel().count();
        Duration duration = Duration.between(start, Instant.now());
        System.out.println("Count = " + count + " in " + duration.toMillis() + " milliseconds");
    }
}
