package com.att.biq.day26.java8.examples.lambda.intro;

/**
 *
 * @author Liron Blecher
 */
//you don't have to add the "@FunctionalInterface" annotation
@FunctionalInterface
//The interface MUST have a single abstract method
//meaning, ONE method definition with no implementation
public interface SomeInterface {
    public void doSomething();
}