package com.att.biq.day27.advance.creator.number;

import com.att.biq.day27.advance.creator.CollectionCreator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCollectionCreator implements CollectionCreator<Integer>
{

    private static Logger log = LogManager.getLogger(
			NumberCollectionCreator.class);

    private Random r = new Random();

    @Override
    public Collection<Integer> create(int total) {
        log.debug("NumberCollectionCreator: about to create new List of integers in the range of [0,100)...");

        Instant start = Instant.now();
        List<Integer> result = IntStream
                .generate(() -> r.nextInt(100))
                .limit(total)
                .boxed()
                .collect(Collectors.toList());
        Instant end = Instant.now();
        log.debug("Creating collection of " + total + " numbers took: " + Duration.between(start, end).toNanos() + " nano seconds...");

        return result;
    }
}
