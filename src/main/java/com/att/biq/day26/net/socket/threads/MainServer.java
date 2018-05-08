package com.att.biq.day26.net.socket.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{

	static public void main(String[] args) throws Exception
	{
		try (ServerSocket server = new ServerSocket(7000))
		{
			while (true)
			{
				Socket socket = server.accept();
				ClientHandler clientHandler = new ClientHandler(socket);
				clientHandler.start();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}