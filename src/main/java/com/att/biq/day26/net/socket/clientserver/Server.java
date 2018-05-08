package com.att.biq.day26.net.socket.clientserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		Socket socket;
		ServerSocket server = new ServerSocket(7000);
		DataInputStream inputStream;
		PrintStream outputStream;
		String line = "";
		try
		{
			// blocking
			socket = server.accept(); 
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new PrintStream(socket.getOutputStream());
			while (!line.equals("!"))
			{
				line = inputStream.readLine();
				outputStream.println(line);
				System.out.println(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}