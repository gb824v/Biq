package com.att.biq.day26.java8.examples.lambda.intro;

public class TestSomeInterfaceMain {
	public static void main(String[] args) {
		// old anonymous way
		SomeInterface obj = new SomeInterface() {
			@Override
			public void doSomething() {
				System.out.println("Old Anonymous Interface Way!");
			}
		};

		// this is another way of writing an anonymous class, like this one:
//		SomeInterface obj = () -> {
//			System.out.println("Old Anonymous Interface Way!");
//		};

		// this is a lambda expression
		// SomeInterface obj = () -> System.out.println("Doing something!");

		obj.doSomething();
	}
}