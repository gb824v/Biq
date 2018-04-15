package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Material implements Comparable<Material>
{
	private MaterialEnum name;
	private int amount;

	public Material()
	{
	}

	public Material(MaterialEnum name, int amount)
	{
		this.name = name;
		this.amount = amount;
	}

	public void save(DataOutputStream dataOut) throws IOException
	{
		dataOut.writeUTF(name.toString());
		dataOut.writeInt(amount);
	}

	public void load(DataInputStream dataIn) throws IOException
	{
		name = MaterialEnum.valueOf(dataIn.readUTF());
		amount = dataIn.readInt();		
	}

	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Material))
		{
			return false;
		}
		return ((Material) o).name.equals(name) && ((Material) o).amount == (amount);
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	public MaterialEnum getName()
	{
		return name;
	}

	public int getAmount()
	{
		return amount;
	}

	@Override
	public int compareTo(Material o)
	{
		return getName().compareTo(o.getName());
	}

}
