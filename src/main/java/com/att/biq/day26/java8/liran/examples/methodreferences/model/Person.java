package com.att.biq.day26.java8.liran.examples.methodreferences.model;


public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + ")";
    }

    //return 0 if p1 age is equal to p2, 1 if greater, -1 if smaller
    public static int compareByAge(Person p1, Person p2) {
        Integer age1 = p1.getAge();
        return age1.compareTo(p2.getAge());
    }

}
