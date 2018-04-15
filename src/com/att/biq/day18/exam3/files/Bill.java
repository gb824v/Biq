package com.att.biq.day18.exam3.files;

import java.io.Serializable;

public class Bill implements Comparable<BillEnum>,Serializable
{
	private static final long serialVersionUID = 1L;
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
