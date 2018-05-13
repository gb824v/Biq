package com.att.biq.day26.net.socket.threads.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer
{

	private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

	public static void main(String[] args) throws IOException
	{
		new ChatServer().run();
	}

	public void run()
	{
		try (ServerSocket serverSocket = new ServerSocket(7000))
		{
			boolean stop = false;
			int counter = 1;
			while (!stop)
			{
				Socket socket = serverSocket.accept(); //blocking...
				try
				{
					ClientHandler clientHandler = new ClientHandler(this, socket, counter++);
					clientHandlers.add(clientHandler);
					clientHandler.start();
				}
				catch (IOException e)
				{
					// TODO: log
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void broadcast(int id, String msg)
	{
		for (ClientHandler client : clientHandlers)
		{
			client.sendMessage(id, msg);
		}
	}

	public void unregister(ClientHandler clientHandler)
	{
		clientHandlers.remove(clientHandler);
	}
} // end of class ChatServer
