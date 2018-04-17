package com.att.biq.day17.exam1.files;


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
