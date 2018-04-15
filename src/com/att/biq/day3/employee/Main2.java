package com.att.biq.day3.employee;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        for (String s : args) {
            Person person = new Person(s);
            persons.add(person);
        }
        System.out.println(Collections.max(persons));
    }
}
