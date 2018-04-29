/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.biq.day26.java8.exam.methodreferences;

import com.att.biq.day26.java8.exam.lambda.predicate.model.Person;

/**
 *
 * @author blechl
 */
public class SuperSpecialPersonComparison {
  
   public int compareByAge(Person p1, Person p2) {
        Integer age1 = p1.getAge();
        return age1.compareTo(p2.getAge());
    }
  
}
