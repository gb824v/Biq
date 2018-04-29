package com.att.biq.day26.java8.examples.streams.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import com.att.biq.day26.java8.examples.lambda.predicate.model.Person;


public class FilterMain {

    public static void main(String[] args) {
        List<Person> beatles = new ArrayList<>();

        beatles.add(new Person("John", 40));
        beatles.add(new Person("Paul", 72));
        beatles.add(new Person("George", 58));
        beatles.add(new Person("Ringo", 74));
        
        Predicate<Person> agePredicate = (p) -> p.getAge() > 70;
        displayPeople(beatles, agePredicate);
    }
    
    private static boolean deadPerson (Person person){
      return person.getAge() < 70;
    }
    
    private static void displayPeople(Collection<Person> people, Predicate<Person> condition){
        people.forEach((p) -> {
            if (condition.test(p)){
                System.out.println(p);
            }
        });
        
//        people
//            .stream()
//            .filter(condition)
//            .forEach(System.out::println);
    }
}
