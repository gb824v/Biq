package com.att.biq.day12.files.binaryfiles2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	// Binary file
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("");
			System.out.println("");
			System.out.println("Enter your choose:");
			System.out.println("1. A Save to file.");
			System.out.println("2. B Read From file.");
			System.out.println("3. C Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			if (str.equalsIgnoreCase("A"))
			{
				System.out.println("Enter your numbers...");
				readInteger(sc);
			}
			else if (str.equalsIgnoreCase("B"))
			{
				System.out.println("Reading From file...");
				readBinaryFile();
			}
			else
			{
				System.out.println("Breaking from program...");
				sc.close();
				break;
			}
		}
	}

	public static void readInteger(Scanner sc) throws Exception
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int number;

		while ((number=sc.nextInt()) != -1)
		{
			arr.add(number);
		}
		saveBinaryFile(arr);
	}

	public static void saveBinaryFile(ArrayList<Integer> arr) throws Exception
	{
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("c:\\file.txt"));

		for (int i : arr)
		{
				dataOut.writeInt(i);
		}
	}

	public static void readBinaryFile() throws Exception
	{
		DataInputStream dataIn = new DataInputStream(new FileInputStream("c:\\file.txt"));

		while (dataIn.available() > 0)
		{
			int j = dataIn.readInt();
			System.out.print(j + " ");
		}
	}
}