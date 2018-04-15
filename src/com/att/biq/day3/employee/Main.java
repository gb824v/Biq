package com.att.biq.day3.employee;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
      int max = -1;
      Person maxPerson = null;
        for (String s : args) {
            Person person = new Person(s);
            persons.add(person);
        }
        System.out.println(persons.toString());

        for (Person person : persons) {
            if (person.getName().length() > max) {
                max = person.getName().length();
                maxPerson = person;
            }
        }
        System.out.println(maxPerson.getName());
    }
}
