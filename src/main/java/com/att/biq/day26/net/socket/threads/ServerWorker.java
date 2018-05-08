package com.att.biq.day26.net.socket.threads;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWorker implements Runnable
{
	Socket socket = null;
	ServerSocket server = null;

	public ServerWorker()
	{
		try
		{
			this.server = new ServerSocket(7000);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{

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
				line = inputStream.readUTF();
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