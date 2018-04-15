package com.att.biq.day10.test1.atm;

public class Bill implements Comparable<BillEnum>
{
	private BillEnum billEnum;

	public Bill(BillEnum billEnum)
	{
		this.billEnum = billEnum;
	}

	public BillEnum getBillEnum()
	{
		return billEnum;
	}

	@Override
	public int hashCode()
	{
		return billEnum.hashCode();
	}

	@Override
	public int compareTo(BillEnum billEnum)
	{
		return billEnum.getValue() - billEnum.getValue();

	}
}
