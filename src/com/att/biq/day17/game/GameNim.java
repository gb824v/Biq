package com.att.biq.day17.game;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameNim
{
	int heaps[] = new int[3];

	private final int PLAYER1 = 1;
	private final int PLAYER2 = 2;

	public GameNim(int heap1, int heap2, int heap3)
	{
		heaps[0] = heap1;
		heaps[1] = heap2;
		heaps[2] = heap3;
	}

	boolean play(int player, int index, int number)
	{
		heaps[index] -= number;
		return isWin("Player-" + player);
	}

	boolean playRandom()
	{
		int index = ThreadLocalRandom.current().nextInt(1, 3);
		int number = ThreadLocalRandom.current().nextInt(1, 10000);

		heaps[index] -= number;
		return isWin("Computer");
	}

	int[] playWise(int index1, int number1)
	{
		for (int i = 0; i < heaps.length; i++)
		{
			for (int j = 0; j < heaps[i]; j++)
			{
				playWise(i, j);
				
				if (isWin())
				{
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	private boolean isWin(String player)
	{
		boolean isWin = isWin();

		if (isWin)
		{
			System.out.println(player + " win!!!");
		}
		return isWin;
	}

	private boolean isWin()
	{
		for (int val : heaps)
		{
			if (val != 0)
			{
				return false;
			}
		}
		return true;
	}

	public void run2Players()
	{
		Scanner kb = new Scanner(System.in);
		int heap = 0, number = 0;
		boolean isWin = true;
		while (isWin)
		{
			System.out.println("Player-A enter heap");
			heap = Integer.parseInt(kb.nextLine());
			System.out.println("Player-A enter number");
			number = Integer.parseInt(kb.nextLine());
			isWin = play(PLAYER1, heap, number);
			System.out.println("Player-B enter heap");
			heap = Integer.parseInt(kb.nextLine());
			System.out.println("Player-B enter number");
			number = Integer.parseInt(kb.nextLine());
			isWin = play(PLAYER2, heap, number);
		}
	}

	public void run1Player()
	{
		Scanner kb = new Scanner(System.in);
		int heap = 0, number = 0;
		boolean isWin = true;
		while (isWin)
		{
			System.out.println("Player-A enter heap");
			heap = Integer.parseInt(kb.nextLine());
			System.out.println("Player-A enter number");
			number = Integer.parseInt(kb.nextLine());
			isWin = play(PLAYER1, heap, number);
			isWin = playRandom();
		}
	}

	public void runWise()
	{
		Scanner kb = new Scanner(System.in);
		int heap = 0, number = 0;
		boolean isWin = true;
		while (isWin)
		{
			System.out.println("Player-A enter heap");
			heap = Integer.parseInt(kb.nextLine());
			System.out.println("Player-A enter number");
			number = Integer.parseInt(kb.nextLine());
			isWin = play(PLAYER1, heap, number);
			isWin = playRandom();
		}
	}
}
