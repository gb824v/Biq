package com.att.biq.day26.java8.examples.interfacemethods;

public class SimpleCircle implements Circle{
    private double radius;
    
    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
