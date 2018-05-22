package com.att.biq.day27.advance.sort;

import java.util.Collection;

public interface SortCollection {
    enum SORT_ALG {BUBBLE, COLLECTION, STREAM};

    <E extends Comparable<E>> Collection<E> sortACollection(Collection<E> input);

    static com.att.biq.day27.advance.sort.SortCollection get(SORT_ALG sortAlg) {
        switch (sortAlg) {
            case BUBBLE:
                return new BubbleSort();
            case COLLECTION:
                return new NativeCollectionBasedSorter();
            case STREAM:
                return new StreamSortBasedSorter();
            default:
                throw new UnsupportedOperationException("Unknown sort algorithm: " + sortAlg);
        }

    }
}
