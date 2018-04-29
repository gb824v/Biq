package com.att.biq.day26.java8.exam.methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.att.biq.day26.java8.exam.lambda.predicate.model.Person;

public class InstanceMethodRefereceMain {

    public static void main(String[] args) {
        InstanceMethodRefereceMain mainClass = new InstanceMethodRefereceMain();
        mainClass.sortData();
    }

    private void sortData() {
        List<Person> beatles = new ArrayList<>();

        beatles.add(new Person("John", 40));
        beatles.add(new Person("Paul", 72));
        beatles.add(new Person("George", 58));
        beatles.add(new Person("Ringo", 74));

        SuperSpecialPersonComparison comparison = new SuperSpecialPersonComparison();
        
        Collections.sort(beatles, comparison::compareByAge);
    }

   
}
