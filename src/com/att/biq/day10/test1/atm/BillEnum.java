package com.att.biq.day10.test1.atm;

public enum BillEnum
{
	M20(20, 10), M50(50, 10), M100(100, 10), M200(200, 10);

	int value;
	int minRequired;

	private BillEnum(int value, int minRequired)
	{
		this.value = value;
		this.minRequired = minRequired;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public int getMinRequired()
	{
		return minRequired;
	}

	public void setMinRequired(int minRequired)
	{
		this.minRequired = minRequired;
	}

}