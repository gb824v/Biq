package com.att.biq.day6.palindrome;

public class Main
{
	public static void main(String[] args)
	{
		for (String s : args)
		{
			if (!s.isEmpty())
			{
				char[] warray = s.toLowerCase().toCharArray();
				System.out.println(s + ":" + istPalindrom(warray));
			}
		}
	}

	public static boolean istPalindrom(char[] sChar)
	{
		for (int i = 0; i < sChar.length / 2 - 1; i++)
		{
			if (sChar[i] != sChar[sChar.length - i - 1])
			{
				return false;
			}
		}
		return true;
	}
}