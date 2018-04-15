package com.att.biq.day17.exam1.files;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class ATM implements Comparable<ATM> , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String id;

	// bills is map that contain the bill and count
	Map<Bill, Integer> bills = new HashMap<Bill, Integer>();

	private int totalAmount;

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

	public static Map<String, ArrayList<Bill>> allAtmsShouldFill(ArrayList<ATM> atms)
	{
		Map<String, ArrayList<Bill>> shouldFill = new HashMap<String, ArrayList<Bill>>();

		for (ATM atm : atms)
		{
			ArrayList<Bill> billList = new ArrayList<Bill>();
			for (Entry<Bill, Integer> billEntry : atm.getBills().entrySet())
			{
				int count = billEntry.getValue();
				Bill bill = billEntry.getKey();

				if (count <= bill.getBillEnum().getMinRequired())
				{
					billList.add(bill);
				}
			}
			shouldFill.put(atm.getId(), billList);
		}
		return shouldFill;
	}

	@Override
	public int compareTo(ATM atm)
	{
		return getTotalAmount() - atm.getTotalAmount();

	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof ATM && ((ATM) o).id.equals(id));
	}

	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
