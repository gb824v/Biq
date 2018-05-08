package com.att.biq.day26.networking.socket;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLEncoder;

public class MyUrlEncoding
{
	public static void main(String args[])
	{
		String line;
		try
		{
			URL u = new URL("https://www.ynet.co.il");
			DataInputStream htmlPage = new DataInputStream(u.openStream());
			while ((line = htmlPage.readUTF()) != null)
			{
				System.out.println(URLEncoder.encode(line, "UTF-8"));
			}
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
}
