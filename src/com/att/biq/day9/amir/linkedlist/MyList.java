package com.att.biq.day9.amir.linkedlist;

import java.util.Iterator;

public class MyList implements Iterable<Integer> {

    private Node first;

    public void add(int num) {
        Node newNode = new Node(num);
        if(first == null) {
            first = newNode;
        }
        else {
            Node curr = first;
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node curr = first;
        while(curr != null) {
            s.append(curr.getValue());
            s.append(' ');
            curr = curr.getNext();
        }
        return s.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(first);
    }
}
