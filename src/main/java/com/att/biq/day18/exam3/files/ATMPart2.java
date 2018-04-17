package com.att.biq.day18.exam3.files;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ATMPart2
{
	String id = "";
	Map<BillEnum, Integer> bills = new HashMap<BillEnum, Integer>();

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
			br.write(id + "");
			br.write(bills.size());
			for (Entry<BillEnum, Integer> bill : bills.entrySet())
			{
				br.write(bill.getKey().toString());
				br.write(bill.getValue());
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

	public void loadFromText(FileInputStream fis) throws IOException
	{
		this.bills.clear();
		int size;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fis)))
		{
			this.id = br.readLine();
			size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++)
			{
				String key = br.readLine();
				int value = Integer.parseInt(br.readLine());
				bills.put(BillEnum.valueOf(key), value);
			}

		}
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
