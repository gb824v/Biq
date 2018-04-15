package com.att.biq.day18.examAll.files;

public enum BillEnum
{
	M20(20), M50(50), M100(100), M200(200);

	int value;

	public static BillEnum getBillEnum(int value)
	{
		BillEnum[] values = BillEnum.values();
		try
		{
			return values[value];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
		}
		return null;

	}

	private BillEnum(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

}