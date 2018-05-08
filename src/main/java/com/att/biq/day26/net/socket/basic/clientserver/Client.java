package com.att.biq.day26.net.socket.basic.clientserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		try (Socket socket = new Socket("localhost", 7000))
		{
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			while (!line.equals("!"))
			{
				line = userInput.readLine();
				System.out.println("Sending to Server: " + line);
				outputStream.println("Geting from Server: " + serverInput.readLine());
			}
		}
	}
}
