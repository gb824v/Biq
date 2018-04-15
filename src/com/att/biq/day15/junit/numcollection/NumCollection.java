package com.att.biq.day15.junit.numcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.att.biq.day10.hascode.Person;

public class NumCollection implements Iterable<Integer>
{

	String numCollectionStr = "";
	private ArrayList<Integer> intArr = new ArrayList<>();
	private String[] strArr;
	private int largest = 0;
	private int smallest = 0;

	public NumCollection(String numCollectionStr)
	{
		this.numCollectionStr = numCollectionStr;
		this.strArr = numCollectionStr.split(",");
		for (String strRange : strArr)
		{
			getNumbers(strRange);
		}
		if (!isSorted())
		{
			throw new NumberFormatException("Not Sorted");
		}
		else
		{
			Collections.sort(intArr);
			smallest = intArr.get(0);
			largest = intArr.get(intArr.size() - 1);
		}
	}

	private void getNumbers(String str)
	{
		String strSplited[] = str.split("-");
		int from = 0;
		int to = 0;
		switch (strSplited.length)
		{
		case 1:
			from = Integer.parseInt(str);
			break;
		case 2:
			from = Integer.parseInt(strSplited[0]);
			to = Integer.parseInt(strSplited[1]);
			break;
		case 3:
			if (str.startsWith("-"))
			{
				from = (Integer.parseInt(strSplited[1])) * -1;
				to = Integer.parseInt(strSplited[2]);
			}
			else
			{
				from = Integer.parseInt(strSplited[0]);
				to = Integer.parseInt(strSplited[3]) * -1;
			}
			break;
		case 4:
			from = Integer.parseInt(strSplited[1]) * -1;
			to = Integer.parseInt(strSplited[3]) * -1;
			addToListNegetiv(from, to);
			return;
		}
		addToList(from, to);
	}

	boolean contain(int value)
	{
		return intArr.contains(value);
	}

	void addToList(int from, int to)
	{
		for (int i = from; i <= to; i++)
		{
			intArr.add(i);
		}
	}

	void addToListNegetiv(int from, int to)
	{
		for (int i = to; i <= from; i++)
		{
			intArr.add(i);
		}
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return intArr.iterator();
	}

	private boolean isSorted()
	{
		boolean sorted = true;
		for (int i = 1; i < intArr.size(); i++)
		{
			if (intArr.get(i - 1).compareTo(intArr.get(i)) > 0)
			{
				sorted = false;
				break;
			}
		}

		return sorted;
	}

	public void print()
	{
		for (int num : intArr)
		{
			System.out.print(num + ",");
		}
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Person && ((NumCollection) o).getIntArr().equals(intArr));
	}

	public int getLargest()
	{
		return largest;
	}

	public int getSmallest()
	{
		return smallest;
	}

	public int getSize()
	{
		return intArr.size();
	}

	public ArrayList<Integer> getIntArr()
	{
		return intArr;
	}

}
