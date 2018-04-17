package com.att.biq.day11.test1.occasions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Occasions
{
	private Person PersonCelebrate;
	private CelebrationEnum celebration;
	private int moneyToCollect = 0;
	private ArrayList<Person> personsThatPaid = new ArrayList<Person>();
	private int additionalManey = 0;
	private Map<Occasions, Float> occasionsRemainders = new HashMap<Occasions, Float>();
	private String perset;
	private int persetCost = 0;

	public Occasions()
	{
		// TODO Auto-generated constructor stub
	}

	public float moneyLeft()
	{
		int sum = 0;
		for (Entry<Occasions, Float> entry : occasionsRemainders.entrySet())
		{
			sum += entry.getValue();
		}
		return ((moneyToCollect * personsThatPaid.size()) + (additionalManey - persetCost) - sum);
	}

	public Person getPersonCelebrate()
	{
		return PersonCelebrate;
	}

	public void setPersonCelebrate(Person personCelebrate)
	{
		PersonCelebrate = personCelebrate;
	}

	public CelebrationEnum getCelebration()
	{
		return celebration;
	}

	public void setCelebration(CelebrationEnum celebration)
	{
		this.celebration = celebration;
	}

	public int getMoneyToCollect()
	{
		return moneyToCollect;
	}

	public void setMoneyToCollect(int moneyToCollect)
	{
		this.moneyToCollect = moneyToCollect;
	}

	public ArrayList<Person> getPersonsThatPaid()
	{
		return personsThatPaid;
	}

	public void setPersonsThatPaid(ArrayList<Person> personsThatPaid)
	{
		this.personsThatPaid = personsThatPaid;
	}

	public int getAdditionalManey()
	{
		return additionalManey;
	}

	public void setAdditionalManey(int additionalManey)
	{
		this.additionalManey = additionalManey;
	}

	public Map<Occasions, Float> getOccasionsRemainders()
	{
		return occasionsRemainders;
	}

	public void setOccasionsRemainders(Map<Occasions, Float> occasionsRemainders)
	{
		this.occasionsRemainders = occasionsRemainders;
	}

	public String getPerset()
	{
		return perset;
	}

	public void setPerset(String perset)
	{
		this.perset = perset;
	}

	public int getPersetCost()
	{
		return persetCost;
	}

	public void setPersetCost(int persetCost)
	{
		this.persetCost = persetCost;
	}
	
}
