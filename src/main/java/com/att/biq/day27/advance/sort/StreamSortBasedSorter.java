package com.att.biq.day27.advance.sort;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamSortBasedSorter implements SortCollection {

    private static Logger log = LogManager.getLogger(
            com.att.biq.day27.advance.sort.StreamSortBasedSorter.class);

    @Override
    public <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input) {

        log.debug("About to sort collection using native stream.sort() method: " + input);
        Instant start = Instant.now();

        ArrayList<E> result = input
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        Instant end = Instant.now();
        log.debug("Sorted collection in: " + Duration.between(start, end).toNanos() + " nano seconds...");

        return result;
    }
}
