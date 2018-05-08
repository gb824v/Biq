package com.att.biq.day26.net.socket.threads;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{

	static public void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(7000);
		while (true)
		{
			Socket socket = server.accept();
			Thread thread = new Thread(new HandleClient(socket));
			thread.start();
		}
	}
}