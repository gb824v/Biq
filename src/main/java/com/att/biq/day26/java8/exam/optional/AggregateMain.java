package com.att.biq.day26.java8.exam.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.att.biq.day26.java8.exam.lambda.predicate.model.Person;


public class AggregateMain {

    public static void main(String[] args) {
        List<Person> beatles = new ArrayList<>();

        beatles.add(new Person("John", 40));
        beatles.add(new Person("Paul", 72));
        beatles.add(new Person("George", 58));
        beatles.add(new Person("Ringo", 74));

        //sum of ages
        long sum = beatles
                    .stream()
                    .mapToInt(Person::getAge)    //return a stream of int
                    .sum();
        System.out.println("Sum of ages = " + sum);
        
        OptionalDouble avg = beatles
                .stream()
                .mapToInt((p) -> p.getAge())
                .average();
        
        //option 1 - check if there is a value
        if (avg.isPresent()){
            System.out.println("Average of ages = " + avg.getAsDouble());
        }
        
        //option 2 - use a lambda!
//        avg.ifPresent(AggregateMain::printAverage);
    }
    
//    static private void  printAverage (double average){
//        System.out.println("Average of ages = " + average);
//    }
}
