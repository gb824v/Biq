package com.att.biq.day11.test1.occasions;

import java.util.ArrayList;
import java.util.Iterator;

public class GiftTable implements Iterable<Occasions>
{

	private CelebrationEnum celebration;

	ArrayList<Occasions> occasionsList = new ArrayList<>();

	@Override
	public Iterator<Occasions> iterator()
	{
		return occasionsList.iterator();
	}

	public ArrayList<Occasions> getOpenOccasions()
	{
		ArrayList<Occasions> openOccasions = new ArrayList<Occasions>();

		for (Occasions occasion : occasionsList)
		{
			if (occasion.getPerset() == null)
			{
				openOccasions.add(occasion);
			}
		}
		return openOccasions;
	}

	public ArrayList<Occasions> getClosedOccasions()
	{
		ArrayList<Occasions> closedOccasions = new ArrayList<Occasions>();

		for (Occasions occasion : occasionsList)
		{
			if (!occasion.getPerset().isEmpty())
			{
				closedOccasions.add(occasion);
			}
		}
		return closedOccasions;
	}

	public ArrayList<Occasions> getMoneyLeft()
	{
		ArrayList<Occasions> moneyLeft = new ArrayList<Occasions>();

		for (Occasions occasion : occasionsList)
		{
			if (occasion.moneyLeft() > 0)
			{
				moneyLeft.add(occasion);
			}
		}
		return moneyLeft;
	}
}
