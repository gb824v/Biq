package com.att.biq.day9.amir.linkedlist;

import java.util.Iterator;

public class ListIterator implements Iterator<Integer> {

    private Node node;

    public ListIterator(Node node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public Integer next() {
        int currVal = node.getValue();
        node = node.getNext();
        return currVal;
    }
}
