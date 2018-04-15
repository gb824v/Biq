package com.att.biq.day18.exam3.files;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ATMPart1 implements Comparable<ATMPart1>, Serializable
{
	private static final long serialVersionUID = 1L;
	String id;

	// bills is map that contain the bill and count
	Map<Bill, Integer> bills = new HashMap<Bill, Integer>();

	private int totalAmount;

	public void clear()
	{
		this.id = null;
		this.bills.clear();
	}

	/**
	 * Add bill to this Atm
	 * 
	 * @param billEnum
	 * @param count
	 */
	public void addBill(BillEnum billEnum, int count)
	{
		Bill bill = new Bill(billEnum);

		if (bills.get(bill) == null)
		{
			bills.put(bill, count);
		}
		else
		{
			Integer num = bills.get(bill);
			num += count;
			bills.put(bill, +num);
		}
	}

	/**
	 * Add bill to this Atm
	 * 
	 * @param billEnum
	 */
	public void addBill(BillEnum billEnum)
	{
		Bill bill = new Bill(billEnum);

		if (bills.get(bill) == null)
		{
			bills.put(bill, 1);
		}
		else
		{
			Integer num = bills.get(bill);
			num += 1;
			bills.put(bill, +num);
		}
	}

	public void removeBill(BillEnum billEnum)
	{
		Bill bill = new Bill(billEnum);

		if (bills.get(bill) == null)
		{
			bills.remove(bill);
		}
		else
		{
			Integer num = bills.get(bill);
			num -= -1;
			bills.put(bill, +num);
		}
	}

	/**
	 * Return all bills in this Atm
	 * 
	 * @return
	 */
	public Map<Bill, Integer> getBills()
	{
		return bills;
	}

	/**
	 * Return total amount for this atm
	 * 
	 * @return
	 */
	public int getTotalAmount()
	{
		Bill bill;
		int count;

		for (Entry<Bill, Integer> billEntry : bills.entrySet())
		{
			bill = billEntry.getKey();
			count = billEntry.getValue();
			totalAmount += bill.getBillEnum().getValue() * count;
		}

		return totalAmount;
	}

	public int getAllBillCount()
	{
		return bills.size();
	}

	/**
	 * Return count of expected bill
	 * 
	 * @param expBill
	 * @return
	 */
	public int getBillCount(Bill expBill)
	{
		for (Entry<Bill, Integer> billEntry : bills.entrySet())
		{
			int count = billEntry.getValue();
			Bill bill = billEntry.getKey();
			if (bill.getBillEnum().equals(expBill.getBillEnum()))
			{
				return count;
			}
		}
		return 0;
	}

	public ArrayList<Bill> getAvalebleBill()
	{
		ArrayList<Bill> avalebleBill = new ArrayList<Bill>();

		for (Entry<Bill, Integer> billEntry : bills.entrySet())
		{
			int count = billEntry.getValue();
			Bill bill = billEntry.getKey();

			if (count > 0)
			{
				avalebleBill.add(bill);
			}
		}
		return avalebleBill;
	}

	@Override
	public int compareTo(ATMPart1 atm)
	{
		return getTotalAmount() - atm.getTotalAmount();

	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof ATMPart1))
		{
			return false;
		}
		return ((ATMPart1) o).id.equals(id) && ((ATMPart1) o).bills.equals(bills);
	}

	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

}
