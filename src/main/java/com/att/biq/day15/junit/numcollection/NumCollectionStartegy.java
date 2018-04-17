package com.att.biq.day15.junit.numcollection;

import java.util.ArrayList;

public abstract class NumCollectionStartegy implements Iterable<Integer>
{
	private int largest = 0;
	private int smallest = 0;
	private int startegy = 0;
	private ArrayList<int[]> pairsList = new ArrayList<int[]>();
	private NumCollectionStartegy1 numCollectionStartegy1 = null;
	private NumCollectionStartegy2 numCollectionStartegy2 = null;
	private NumCollectionStartegy3 numCollectionStartegy3 = null;

	public NumCollectionStartegy(String numCollectionStr)
	{
		setStrategy(numCollectionStr.split(","));

		if ((startegy + 1) <= 1000)
		{
			numCollectionStartegy1 = new NumCollectionStartegy1(numCollectionStr);
		}
		else if (pairsList.size() <= 100)
		{
			numCollectionStartegy2 = new NumCollectionStartegy2(numCollectionStr);
		}
		else
		{
			numCollectionStartegy3 = new NumCollectionStartegy3(numCollectionStr);
		}

	}

	public void setStrategy(String[] strArr)
	{
		int[] pairs;
		if (strArr.length > 0)
		{
			pairs = getPairs(strArr[0]);
			smallest = pairs[0];
			largest = pairs[1];

			for (String strRange : strArr)
			{
				pairs = getPairs(strRange);
				pairsList.add(pairs);
				if (smallest > pairs[0])
				{
					smallest = pairs[0];
				}
				if (smallest > pairs[1])
				{
					largest = pairs[1];
				}
			}
		}
		startegy = largest - smallest;
	}

	private int[] getPairs(String str)
	{
		String strSplited[] = str.split("-");
		int[] pairsArr = new int[2];
		switch (strSplited.length)
		{
		case 1:
			pairsArr[0] = Integer.parseInt(str);
			break;
		case 2:
			pairsArr[0] = Integer.parseInt(strSplited[0]);
			pairsArr[1] = Integer.parseInt(strSplited[1]);
			break;
		case 3:
			if (str.startsWith("-"))
			{
				pairsArr[0] = (Integer.parseInt(strSplited[1])) * -1;
				pairsArr[1] = Integer.parseInt(strSplited[2]);
			}
			else
			{
				pairsArr[0] = Integer.parseInt(strSplited[0]);
				pairsArr[1] = Integer.parseInt(strSplited[3]) * -1;
			}
			break;
		case 4:
			pairsArr[0] = Integer.parseInt(strSplited[1]) * -1;
			pairsArr[1] = Integer.parseInt(strSplited[3]) * -1;
		}
		return pairsArr;
	}

	public int getLargest()
	{
		return largest;
	}

	public int getSmallest()
	{
		return smallest;
	}

}
