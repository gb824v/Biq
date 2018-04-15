package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MaterialDest implements Comparable<MaterialDest>
{
	private Machine machineDestination;
	private Material material;
	private boolean isFinal = false;

	public MaterialDest()
	{
	}

	public MaterialDest(Material material, Machine machineDestination)
	{
		this.machineDestination = machineDestination;
		this.material = material;
		this.isFinal = false;
	}

	public MaterialDest(Material material)
	{
		this.material = material;
		this.isFinal = true;
	}

	public void save(DataOutputStream dataOut) throws IOException
	{
		this.material.save(dataOut);
		dataOut.writeUTF(Boolean.toString(isFinal));
		if (!isFinal)
		{
			machineDestination.save(dataOut);
		}
		
	}

	public void load(DataInputStream dataIn) throws IOException
	{
		Material materialNew = new Material();
		Machine machineDestination = new Machine();
		materialNew.load(dataIn);
		this.material = materialNew;
		this.isFinal = Boolean.parseBoolean(dataIn.readUTF());
		if (!isFinal)
		{
			machineDestination.load(dataIn);
			this.machineDestination = machineDestination;
		}
		
	}

	public Machine getMachineDestination()
	{
		return machineDestination;
	}

	public void setMachineDestination(Machine machineDestination)
	{
		this.machineDestination = machineDestination;
	}

	public Material getMaterial()
	{
		return material;
	}

	public void setMaterial(Material material)
	{
		this.material = material;
	}

	public boolean isFinal()
	{
		return isFinal;
	}

	public void setFinal(boolean isFinal)
	{
		this.isFinal = isFinal;
	}

	@Override
	public int compareTo(MaterialDest o)
	{
		return material.compareTo(o.getMaterial());
	}

}
