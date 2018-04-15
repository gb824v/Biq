package com.att.biq.day8.interfaces;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {
    private int index = -1;
    private String s;

    public MyStringIterator(String s) {
        this.s = s;
    }

    @Override
    public boolean hasNext() {
        return index + 1 < s.length();
    }

    @Override
    public Character next() {
        return s.charAt(++index);
    }
}
