package com.att.biq.day8.interfaces;

public class Main {

    public static void main(String[] args) {
        MyString s = new MyString("hello");
        for(char c : s) {
            System.out.println(c);
        }
    }

}
