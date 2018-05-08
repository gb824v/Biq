package com.att.biq.day26.net.socket.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		Socket socket;
		ServerSocket server = new ServerSocket(7000);
		String line = "";
		try
		{
			// blocking
			socket = server.accept();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			while (!line.equals("!"))
			{
				line = bufferedReader.readLine();
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