package com.att.biq.day26.java8.exam.lambda.builtin;

public class RunnableMain {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Running Thread 1")).start();
        new Thread(() -> System.out.println("Running Thread 2")).start();
    }
}
