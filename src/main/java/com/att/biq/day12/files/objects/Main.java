package com.att.biq.day12.files.objects;

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
		HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
		myHashMap.put("Guy", 10);
		myHashMap.put("Ilan", 100);
		myHashMap.put("Doron", 200);
		saveHashmap(myHashMap);
	}

	public static void saveHashmap(HashMap<String, Integer> map)
	{
		try
		{
			ObjectOutputStream dataOut = new ObjectOutputStream(new FileOutputStream("c:\\file.txt"));
			dataOut.writeObject(map);
			dataOut.flush();
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
			HashMap<String, Integer> mapInFile = (HashMap<String, Integer>) ois.readObject();
			ois.close();
			for (Map.Entry<String, Integer> m : mapInFile.entrySet())
			{
				System.out.println(m.getKey() + " : " + m.getValue());
			}
		}
		catch (Exception e)
		{
		}
	}
}