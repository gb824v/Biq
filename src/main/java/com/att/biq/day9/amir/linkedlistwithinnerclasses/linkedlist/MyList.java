package com.att.biq.day9.amir.linkedlistwithinnerclasses.linkedlist;

import java.util.Iterator;

public class MyList implements Iterable<Integer> {

    private static class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

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

    public class ListIterator implements Iterator<Integer> {

        private Node node;

        public ListIterator(Node node) {
            this.node = node;
        }
        public ListIterator() {
            this.node = first;
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

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(first);
    }
}
