package com.att.biq.day26.net.socket.threads;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConsumer implements Runnable
{
	ServerSocket server;
	public ServerConsumer(ServerSocket server)
	{
		this.server = server;
	}
	@Override
	public void run()
	{
		String line = "";
		try
		{
			Socket socket = server.accept();
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
