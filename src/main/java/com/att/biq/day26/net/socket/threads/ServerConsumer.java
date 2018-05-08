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
		Socket socket =null;
		try
		{
			socket = server.accept();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream outputStream = new PrintStream(socket.getOutputStream());
			while (!line.equals("!"))
			{
				line = bufferedReader.readLine();
				outputStream.println(Thread.currentThread().getName() + "-> " + line);
				System.out.println(line);
			}
			socket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
