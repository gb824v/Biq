package com.att.biq.day26.net.socket.clientserver;

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
		Socket socket = null;
		String line = "";
		try (ServerSocket server = new ServerSocket(7000))
		{
			// blocking
			socket = server.accept();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			while (!line.equals("!"))
			{
				line = bufferedReader.readLine();
				System.out.println("Getting from Client: -> " + line);
				outputStream.println("Sending to Client: -> " + line);
			}
			socket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}