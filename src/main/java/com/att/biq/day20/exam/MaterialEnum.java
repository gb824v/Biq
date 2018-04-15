package com.att.biq.day20.exam;

public enum MaterialEnum
{
	SHALBUK, TALPAZ, YAMBUK, PLANCHA, DARGASH, GALMOR;

	int value;

	public static MaterialEnum getMaterialEnum(int value)
	{
		MaterialEnum[] values = MaterialEnum.values();
		try
		{
			return values[value];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
		}
		return null;

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
