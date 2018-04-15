package com.att.biq.day24.threads.blockingstack;

import java.util.Scanner;

public class Main
{
	static public void main(String[] args) throws InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		String msg = "";
		BlockingStack<String> bs = new BlockingStack<String>(10);
		Thread consumer = new Thread(new Consumer(bs));
		consumer.start();
		while (!msg.equals("stop"))
		{
			System.out.println("Enter your string...");
			msg = sc.nextLine();
			bs.push(msg);
		}
		sc.close();
	}
}
