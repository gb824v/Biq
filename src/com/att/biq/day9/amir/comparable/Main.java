package com.att.biq.day9.amir.comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] pArr = new Person[]{
                new Person("Momo", 12),
                new Person("Koko", 19),
                new Person("Noa", 17),
                new Person("Momo", 102)
        };
        System.out.println(Arrays.toString(pArr));
        Arrays.sort(pArr);
        System.out.println(Arrays.toString(pArr));
    }
}
