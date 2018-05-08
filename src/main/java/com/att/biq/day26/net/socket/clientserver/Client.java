package com.att.biq.day26.net.socket.clientserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		try (Socket socket = new Socket("localhost", 7000))
		{
			try (DataInputStream inputStream = new DataInputStream(socket.getInputStream()))
			{
				String line = "";
				PrintStream outputStream = new PrintStream(socket.getOutputStream());
				DataInputStream userInput = new DataInputStream(System.in);
				while (!line.equals("!"))
				{
					line = userInput.readUTF();
					outputStream.println(line);
				}
				System.out.println(inputStream.readUTF());
			}
		}
	}
}
