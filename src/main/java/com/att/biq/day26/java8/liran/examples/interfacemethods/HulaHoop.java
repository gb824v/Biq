package com.att.biq.day26.java8.liran.examples.interfacemethods;

public class HulaHoop implements Circle {
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
