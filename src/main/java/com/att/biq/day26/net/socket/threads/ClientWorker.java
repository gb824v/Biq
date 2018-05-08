package com.att.biq.day26.net.socket.threads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientWorker implements Runnable
{
	@Override
	public void run()
	{
		try (Socket socket = new Socket("localhost", 7000))
		{
			try (DataInputStream inputStream = new DataInputStream(socket.getInputStream()))
			{
				String line = "";
				PrintStream outputStream = new PrintStream(socket.getOutputStream());
				BufferedReader userInput = new BufferedReader(new InputStreamReader (System.in));
				while (!line.equals("!"))
				{
					line = userInput.readLine();
					outputStream.println(line);
				}
				System.out.println(inputStream.readUTF());
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
