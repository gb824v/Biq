package com.att.biq.day26.java8.exam.interfacemethods;

public class DefaultMethodsMain {
    public static void main(String[] args) {
        Circle myCircle = new SimpleCircle();
        myCircle.setRadius(10);
        
        System.out.println("Circle Area is: " + myCircle.area());
        
    }
}
