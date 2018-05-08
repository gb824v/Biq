package com.att.biq.day26.net.socket.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread
{
	Socket socket;

	public ClientHandler(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		String line = "";

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
		{
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			while (!line.equals("!"))
			{
				line = bufferedReader.readLine();
				System.out.println(Thread.currentThread().getName() + " Getting from Client: -> " + line);
				outputStream.println(Thread.currentThread().getName() + " Sending to Client: -> " + line);

			}
		}
		catch (Exception e)
		{
			System.out.println("Client is disconnect !!!");
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				// ignore
			}
		}
	}
}
