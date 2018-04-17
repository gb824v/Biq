package com.att.biq.day11.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		//printLinesFromFile("c:\\file.txt");
		printAllLinesFromFile("c:\\file.txt");
	}

	static void printLinesFromFile(String path) throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			String str = "";
			while (str != null)
			{
				System.out.println(br.readLine().toUpperCase());
			}
		}
		catch (Exception e)
		{

		}
	}

	static void printAllLinesFromFile(String path) throws IOException
	{
		try
		{
			for (String line : Files.readAllLines(Paths.get(path),Charset.forName("UTF-8")))
			{
				System.out.println(line.toUpperCase());
			}
		}
		catch (IOException ex)
		{
			return;
		}
	}
}