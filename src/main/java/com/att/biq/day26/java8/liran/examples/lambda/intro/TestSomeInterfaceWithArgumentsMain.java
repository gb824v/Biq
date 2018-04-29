package com.att.biq.day26.java8.liran.examples.lambda.intro;

public class TestSomeInterfaceWithArgumentsMain {
    public static void main(String[] args) {
        SomeInterfaceWithArgs obj = (v1, v2) -> v1 + v2;

        int calcResult = obj.doSomething(5, 10);
        System.out.println("Result = " + calcResult);
    }
}
