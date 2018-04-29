package com.att.biq.day26.java8.liran.examples.lambda.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.att.biq.day26.java8.liran.examples.lambda.predicate.model.Person;

public class PredicateMain {

    public static void main(String args[]) {
        List<Person> beatles = new ArrayList<>();

        beatles.add(new Person("John", 40));
        beatles.add(new Person("Paul", 72));
        beatles.add(new Person("George", 58));
        beatles.add(new Person("Ringo", 74));
        
//        Predicate<Person> ageCondition = new Predicate<Person>() {
//            @Override
//            public boolean test(Person t) {
//                if (t.getAge() > 70){
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        };
        Predicate<Person> agePredicate = (person) -> person.getAge() > 70;

        
//        for (Person beatle : beatles) {
//            if (agePredicate.test(beatle)){
//                System.out.println(beatle);
//            }
//        }
        beatles.forEach(p -> {
            if (agePredicate.test(p)){
                System.out.println(p);
            }
        });
    }
}
