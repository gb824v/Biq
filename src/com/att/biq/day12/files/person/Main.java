package com.att.biq.day12.files.person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		HashMap<Person, Integer> myHashMap = new HashMap<Person, Integer>();
		myHashMap.put(new Person("Guy"), 10);
		myHashMap.put(new Person("Ilan"), 100);
		myHashMap.put(new Person("Doron"), 200);
		saveHashmap(myHashMap);
		readHashmap();
	}

	public static void saveHashmap(HashMap<Person, Integer> myHashMap)
	{
		try
		{
			ObjectOutputStream dataOut = new ObjectOutputStream(new FileOutputStream("c:\\file.txt"));
			dataOut.writeObject(myHashMap);
			dataOut.close();
		}
		catch (Exception e)
		{
		}
	}

	// read from file
	public static void readHashmap()
	{
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\file.txt"));
			HashMap<Person, Integer> mapInFile = (HashMap<Person, Integer>) ois.readObject();
			ois.close();
			for (Map.Entry<Person, Integer> m : mapInFile.entrySet())
			{
				System.out.println(m.getKey() + " : " + m.getValue());
			}
		}
		catch (Exception e)
		{
		}
	}
}