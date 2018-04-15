package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MaterialsDestList implements Iterable<MaterialDest>
{
	private Set<MaterialDest> materialDestList = new TreeSet<MaterialDest>();

	public void save(DataOutputStream dataOut) throws IOException
	{
		dataOut.writeInt(materialDestList.size());
		for (MaterialDest materialDest : materialDestList)
		{
			materialDest.save(dataOut);
		}
	}

	public void load(DataInputStream datain) throws IOException
	{
		this.materialDestList.clear();
		int size = datain.readInt();

		for (int i = 0; i < size; i++)
		{
			MaterialDest materialDest = new MaterialDest();
			materialDest.load(datain);
			materialDestList.add(materialDest);
		}
	}

	public void clear()
	{
		materialDestList.clear();
	}

	public void add(Material material, Machine machineDestination)
	{
		MaterialDest materialDest = new MaterialDest(material, machineDestination);
		materialDestList.add(materialDest);
	}

	public void add(Material material)
	{
		MaterialDest materialDest = new MaterialDest(material);
		materialDestList.add(materialDest);
	}

	public void find(String materialName)
	{
		for (MaterialDest material : materialDestList)
		{
			if (material.getMaterial().getName().equals(materialName))
			{
				materialDestList.remove(material);
			}
		}
	}

	public void remove(MaterialDest material)
	{
		materialDestList.remove(material);
	}

	public Set<MaterialDest> getMaterialList()
	{
		return materialDestList;
	}

	public int size()
	{
		return materialDestList.size();
	}

	@Override
	public Iterator<MaterialDest> iterator()
	{
		return materialDestList.iterator();
	}

	public boolean contains(MaterialDest materialDest)
	{
		return materialDestList.contains(materialDest);
	}

	@Override
	public int hashCode()
	{
		return materialDestList.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof MaterialsDestList && ((MaterialsDestList) o).materialDestList.equals(materialDestList));
	}
}
