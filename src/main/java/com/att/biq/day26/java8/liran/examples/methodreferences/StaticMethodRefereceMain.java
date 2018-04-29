package com.att.biq.day26.java8.liran.examples.methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.att.biq.day26.java8.liran.examples.methodreferences.model.Person;


public class StaticMethodRefereceMain {

    public static void main(String[] args) {
        List<Person> beatles = new ArrayList<>();

        beatles.add(new Person("John", 40));
        beatles.add(new Person("Paul", 72));
        beatles.add(new Person("George", 58));
        beatles.add(new Person("Ringo", 74));

        //option 1 - anonymous interface
        Collections.sort(beatles, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                Integer age1 = o1.getAge();
                return age1.compareTo(o2.getAge());
            }
        });
        
        //option 2 - lambda expression
        Collections.sort(beatles, (p1, p2) -> {
            Integer age1 = p1.getAge();
            return age1.compareTo(p2.getAge());
        });
        
        //option 3 - single line lambda expression
        Collections.sort(beatles, (p1, p2) -> new Integer(p1.getAge()).compareTo(p2.getAge()));
        
        //option 4 - method reference
        Collections.sort(beatles, Person::compareByAge);
    }
}