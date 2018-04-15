package com.att.biq.day16.junit.towersofhanoi;

public class TowersOfHanoi
{
	private final int MAX_SIZE = 64;

	public TowersOfHanoi(int n, String startPole, String middlePole, String endPole)
	{
		if (n < 1 || n > MAX_SIZE)
		{
			throw new IllegalArgumentException(
					String.format("Number of rings (%s) cannot be less than 1 or exceed " + MAX_SIZE, n));
		}
		if (startPole.isEmpty() || middlePole.isEmpty() || endPole.isEmpty())
		{
			throw new IllegalArgumentException("startPole or middlePole endPole cano't be empty");
		}
		if (startPole == null || middlePole == null || endPole == null)
		{
			throw new NullPointerException("startPole or middlePole endPole cano't be null");
		}
		else
		{
			move(n, startPole, middlePole, endPole);
		}
	}

	public static void move(int n, String startPole, String middlePole, String endPole) throws NumberFormatException
	{
		if (n == 1)
		{
			System.out.println(startPole + " --> " + endPole);
		}
		else
		{
			move(n - 1, startPole, endPole, middlePole);
			System.out.println(startPole + " --> " + endPole);
			move(n - 1, middlePole, startPole, endPole);
		}
	}
}