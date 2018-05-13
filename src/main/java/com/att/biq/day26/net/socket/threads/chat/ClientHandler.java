package com.att.biq.day26.net.socket.threads.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread
{
	private ChatServer server;
	private Socket socket;
	private final int id;
	private PrintStream outputStream;

	public ClientHandler(ChatServer server, Socket socket, int id) throws IOException
	{
		this.server = server;
		this.socket = socket;
		this.id = id;
		outputStream = new PrintStream(socket.getOutputStream());
	}

	@Override public void run()
	{
		try
		{
			String msg = "";
			BufferedReader inputStream;
			System.out.println("new client connected...");
			inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (!msg.equals("!"))
			{
				msg = inputStream.readLine();
				server.broadcast(id, msg);
				System.out.println(msg);
			}
		}
		catch (Exception e)
		{
			System.out.println("client disconnected during !");
		}
		finally
		{
			try
			{
				server.unregister(this);
				socket.close();
			}
			catch (IOException e)
			{
				// ignore
			}
		}
	}

	public void sendMessage(int id, String msg)
	{
		if (id != this.id)
		{
			outputStream.println("" + id + ": " + msg);
		}
	}

} // end of inner class ClientHandler
