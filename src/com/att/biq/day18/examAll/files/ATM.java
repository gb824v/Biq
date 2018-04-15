package com.att.biq.day18.examAll.files;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ATM implements Comparable<ATM>, Serializable
{
	private static final long serialVersionUID = 1L;
	private String id = "";
	private Map<BillEnum, Integer> bills = new HashMap<BillEnum, Integer>();
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

		if (bills.get(billEnum) == null)
		{
			bills.put(billEnum, count);
		}
		else
		{
			Integer num = bills.get(billEnum);
			num += count;
			bills.put(billEnum, +num);
		}
	}

	public void saveAsBinary(FileOutputStream fos) throws IOException
	{
		try (DataOutputStream dataOut = new DataOutputStream(fos))
		{
			dataOut.writeChars(id);
			dataOut.writeInt(bills.size());
			for (Entry<BillEnum, Integer> bill : bills.entrySet())
			{
				dataOut.writeUTF(bill.getKey().toString());
				dataOut.writeInt(bill.getValue());
			}
		}
	}

	public void saveAsText(FileOutputStream fos) throws IOException
	{
		try (OutputStreamWriter br = new OutputStreamWriter(fos))
		{
			if (!id.isEmpty())
			{
				br.write(id + "\n");
			}
			else
			{
				br.write("empty" + "\n");
			}
			br.write(bills.size() + "\n");
			for (Entry<BillEnum, Integer> bill : bills.entrySet())
			{
				br.write(bill.getKey() + "\n");
				br.write(bill.getValue() + "\n");
			}
		}
	}

	public void loadAsBinary(FileInputStream fis) throws IOException
	{
		this.bills.clear();
		int size;
		try (DataInputStream datain = new DataInputStream(fis))
		{
			this.id = datain.readUTF();
			size = datain.readInt();
			for (int i = 0; i < size; i++)
			{
				String key = datain.readUTF();
				int value = datain.readInt();
				bills.put(BillEnum.valueOf(key), value);
			}
		}
	}

	public void loadAsText(FileInputStream fis) throws IOException
	{
		this.bills.clear();
		int size;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fis)))
		{
			this.id = br.readLine();
			size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++)
			{
				String billMonetaryValue = br.readLine();
				int amount = Integer.parseInt(br.readLine());
				bills.put(BillEnum.valueOf(billMonetaryValue), amount);
			}

		}
	}

	/**
	 * Add bill to this Atm
	 * 
	 * @param billEnum
	 */
	public void addBill(BillEnum billEnum)
	{

		if (bills.get(billEnum) == null)
		{
			bills.put(billEnum, 1);
		}
		else
		{
			Integer num = bills.get(billEnum);
			num += 1;
			bills.put(billEnum, +num);
		}
	}

	public void removeBill(BillEnum billEnum)
	{

		if (bills.get(billEnum) == null)
		{
			bills.remove(billEnum);
		}
		else
		{
			Integer num = bills.get(billEnum);
			num -= -1;
			bills.put(billEnum, +num);
		}
	}

	/**
	 * Return all bills in this Atm
	 * 
	 * @return
	 */
	public Map<BillEnum, Integer> getBills()
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
		int count;
		BillEnum billEnum;
		for (Entry<BillEnum, Integer> billEntry : bills.entrySet())
		{
			billEnum = billEntry.getKey();
			count = billEntry.getValue();
			totalAmount += billEnum.getValue() * count;
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
	public int getBillCount(BillEnum expBillEnum)
	{
		for (Entry<BillEnum, Integer> billEntry : bills.entrySet())
		{
			int count = billEntry.getValue();
			BillEnum billEnum = billEntry.getKey();
			if (billEnum.equals(expBillEnum))
			{
				return count;
			}
		}
		return 0;
	}

	public ArrayList<BillEnum> getAvalebleBill()
	{
		ArrayList<BillEnum> avalebleBill = new ArrayList<BillEnum>();

		for (Entry<BillEnum, Integer> billEntry : bills.entrySet())
		{
			int count = billEntry.getValue();
			BillEnum billEnum = billEntry.getKey();

			if (count > 0)
			{
				avalebleBill.add(billEnum);
			}
		}
		return avalebleBill;
	}

	@Override
	public int compareTo(ATM atm)
	{
		return getTotalAmount() - atm.getTotalAmount();

	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof ATM))
		{
			return false;
		}
		return ((ATM) o).id.equals(id) && ((ATM) o).bills.equals(bills);
	}

	@Override
	public int hashCode()
	{
		return id.hashCode();
	}

}
