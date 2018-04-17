package com.att.biq.day24.threads.consumer;

import java.util.Scanner;

public class Main
{
	static public void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String msg = "";
		Drop drop = new Drop();
		Thread consumer = new Thread(new Consumer(drop));
		consumer.start();
		while (!msg.equals("stop"))
		{
			System.out.println("Enter your string...");
			msg = sc.nextLine();
			drop.push(msg);
		}
		sc.close();
	}
}
