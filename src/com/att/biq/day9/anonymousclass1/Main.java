package com.att.biq.day9.anonymousclass1;

import com.att.biq.day9.anonymousclass1.HelloWorldAnonymousClasses.HelloWorld;

public class Main
{
	public static void main(String[] args)
	{
		 HelloWorld frenchGreeting = new HelloWorld() {
	            String name = "tout le monde";
	            public void greet() {
	                greetSomeone("tout le monde");
	            }
	            public void greetSomeone(String someone) {
	                name = someone;
	                System.out.println("Salut " + name);
	            }
	        };
	        frenchGreeting.greet();
	}
}
