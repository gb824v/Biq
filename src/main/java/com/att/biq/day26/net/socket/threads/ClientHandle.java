package com.att.biq.day26.net.socket.threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandle implements Runnable
{
	Socket socket;

	public ClientHandle(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		String line = "";

		try
		{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			while (true)
			{
				line = bufferedReader.readLine();
				String str = Thread.currentThread().getName() + " Get from Client: -> " + line;
				System.out.println(str);
				str = Thread.currentThread().getName() + " Sending to Client: -> " + line;
				outputStream.println(str);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
