package com.att.biq.day25.threads.threadlocal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ThreadLocalOcurence implements Runnable
{

	private ThreadLocal<Map<String, Integer>> threadLocal = new ThreadLocal<Map<String, Integer>>();
	private Map<String, Integer> charCounter;
	private String filePath;

	public ThreadLocalOcurence(Map<String, Integer> charCounter, String filePath)
	{
		this.filePath = filePath;
		this.charCounter = charCounter;
	}

	@Override
	public void run()
	{
		threadLocal.set(charCounter);

		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			readNumOfOcurence(br);
		}
		catch (IOException e1)
		{
		}

		System.out.println(threadLocal.get());
	}

	private void readNumOfOcurence(BufferedReader br) throws IOException
	{
		String temp = "";

		while ((temp = br.readLine()) != null)
		{
			String[] spliter = temp.split(" ");
			for (String temp1 : spliter)
				if (charCounter.containsKey(temp1))
				{
					charCounter.put(temp1, charCounter.get(temp1) + 1);
				}
				else
				{
					charCounter.put(temp1, 1);
				}
		}
	}

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException
	{
		Map<String, Integer> charCounter = new HashMap<String, Integer>();

		ThreadLocalOcurence sharedRunnableInstance1 = new ThreadLocalOcurence(charCounter, "c:\\NumOfOc1.txt");
		ThreadLocalOcurence sharedRunnableInstance2 = new ThreadLocalOcurence(charCounter, "c:\\NumOfOc2.txt");

		Thread thread1 = new Thread(sharedRunnableInstance1);
		Thread thread2 = new Thread(sharedRunnableInstance2);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}