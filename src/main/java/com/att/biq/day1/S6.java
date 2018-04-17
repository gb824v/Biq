package com.att.biq.day1;

public class S6
{

	public static void main(String[] args)
	{
		String str = "Hey how are you?";
		int counter = 0;
		String[] strArr = new String [str.length()];
		for (int index = 0; index < str.length(); index++)
		{
			counter = 0;
			char c = str.charAt(index);
			for (int i = 0; i < str.length(); i++)
			{
				if (Character.isLetter(str.charAt(i)))
				{
					if (str.charAt(i) == c)
					{
						counter++;
					}
				}
			}
			if (counter > 0)
			{
				strArr[index] = c + " " + getBs(counter);
			}
		}
		printArr(strArr);
	}

	public static String getBs(int num)
	{
		String str = "";
		for (int i = 0; i < num; i++)
		{
			str += "#";
		}
		return str;
	}
	public static void printArr(String[] strArr)
	{
		
		for (int i = 0; i < strArr.length; i++)
		{
			if (strArr[i]!=null)
			System.out.println(strArr[i]);
		}
		
	}
}