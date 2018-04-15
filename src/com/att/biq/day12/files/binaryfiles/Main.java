package com.att.biq.day12.files.binaryfiles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		int[] arr = new int[]
		{ 1, 2, 300, 4, 5000 };
		// writing string to a file encoded as modified UTF-8
		DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("c:\\file.txt"));

		for (int i : arr)
		{
			dataOut.writeInt(i);
		}

		// Reading data from the same file
		DataInputStream dataIn = new DataInputStream(new FileInputStream("c:\\file.txt"));

		while (dataIn.available() > 0)
		{
			int k = dataIn.readInt();
			System.out.print(k + " ");
		}
	}
}