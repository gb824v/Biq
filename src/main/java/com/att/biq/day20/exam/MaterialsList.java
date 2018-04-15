package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MaterialsList implements Iterable<Material>
{
	private Set<Material> materialList = new TreeSet<Material>();

	public boolean containSubList(MaterialsList sublist)
	{
		boolean status = true;

		for (Material material : sublist)
		{
			if (materialList.contains(material))
			{
				status = true;
			}
			else
			{
				return false;
			}
		}
		return status;
	}

	public void save(DataOutputStream dataOut) throws IOException
	{
		dataOut.writeInt(materialList.size());
		for (Material material : materialList)
		{
			material.save(dataOut);
		}
	}

	public void load(DataInputStream datain) throws IOException
	{
		this.materialList.clear();
		int size = datain.readInt();

		for (int i = 0; i < size; i++)
		{
			Material material = new Material();
			material.load(datain);
			materialList.add(material);
		}
	}

	public void clear()
	{
		materialList.clear();
	}

	public void add(MaterialEnum name, int amount)
	{
		Material material = new Material(name, amount);
		materialList.add(material);
	}

	public void find(String materialName)
	{
		for (Material material : materialList)
		{
			if (material.getName().equals(materialName))
			{
				materialList.remove(material);
			}
		}
	}

	public void removeSubList(MaterialsList list2Remove)
	{
		for (Material material : list2Remove)
		{
			materialList.remove(material);
		}
	}

	public void remove(Material material)
	{
		materialList.remove(material);
	}

	public Set<Material> getMaterialList()
	{
		return materialList;
	}

	public int size()
	{
		return materialList.size();
	}

	@Override
	public Iterator<Material> iterator()
	{
		return materialList.iterator();
	}

	public boolean contains(Material material)
	{
		return materialList.contains(material);
	}

	@Override
	public int hashCode()
	{
		return materialList.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof MaterialsList && ((MaterialsList) o).materialList.equals(materialList));
	}

}
