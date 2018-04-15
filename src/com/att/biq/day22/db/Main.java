package com.att.biq.day22.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws IOException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		String msg = "";
		while (!msg.equals("stop"))
		{
			System.out.println("Enter your string...");
			msg = sc.nextLine();
		}
		sc.close();
	}
}
