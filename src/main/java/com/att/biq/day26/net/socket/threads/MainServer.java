package com.att.biq.day26.net.socket.threads;

import java.net.ServerSocket;

public class MainServer
{

	static public void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(7000);
		ServerConsumer consumer = new ServerConsumer(server);
	}
}