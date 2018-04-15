package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Factory
{
	private String name;
	private HashMap<String, Machine> machines = new HashMap<String, Machine>();
	private MaterialsDestList finalMaterialsList = new MaterialsDestList();

	public Factory(String name)
	{
		this.name = name;
	}

	public void clear()
	{
		name = "";
		machines.clear();
		finalMaterialsList.clear();
	}

	private void verifyOrThrow(MaterialsDestList materialOutputSchemaRes) throws MissingMachineException, IligalProductMachineException
	{
		for (MaterialDest materialDest : materialOutputSchemaRes)
		{
			if (materialDest.getMachineDestination() != null)
			{
				
				String name = materialDest.getMachineDestination().getName();
				if (machines.get(name) == null)
				{
					throw new MissingMachineException(name);
				}
				else
				{
					Material material = materialDest.getMaterial();
					Machine machine = machines.get(name);
					
					if (!machine.getMaterialInSchema().contains(material))
					{
						throw new IligalProductMachineException(machine.getName(),material.getName().toString());
					}
				}

			}
		}
	}

	public void addMachine(Machine machine)
	{
		machines.put(machine.getName(), machine);
	}

	public MaterialsDestList doWork(int times) throws MissingMachineException, IligalProductMachineException
	{
		for (int i = 0; i < times; i++)
		{
			for (Entry<String, Machine> machineSet : machines.entrySet())
			{
				MaterialsDestList materialOutputSchemaRes = machineSet.getValue().doWork();

				if (materialOutputSchemaRes != null)
				{
					machinePushMaterial(materialOutputSchemaRes);
				}
			}
		}
		return finalMaterialsList;
	}

	public void machinePushMaterial(MaterialsDestList materialOutputSchemaRes) throws MissingMachineException, IligalProductMachineException
	{
		verifyOrThrow(materialOutputSchemaRes);
		for (MaterialDest materialDest : materialOutputSchemaRes)
		{
			Material material = materialDest.getMaterial();
			if (materialDest.getMachineDestination() != null)
			{
				String name = materialDest.getMachineDestination().getName();
				machines.get(name).pushMaterial(material.getName(), material.getAmount());
			}
			else
			{
				finalMaterialsList.add(material);
			}
		}
	}

	public void save(File factoryBinFile) throws IOException
	{
		try (FileOutputStream fos = new FileOutputStream(factoryBinFile))
		{
			DataOutputStream dataOut = new DataOutputStream(fos);
			{
				dataOut.writeInt(machines.size());
				for (Entry<String, Machine> machineSet : machines.entrySet())
				{
					machineSet.getValue().save(dataOut);
				}
				finalMaterialsList.save(dataOut);
			}
		}
	}

	public void load(File factoryBinFile) throws IOException
	{
		try (FileInputStream fis = new FileInputStream(factoryBinFile))
		{
			DataInputStream datain = new DataInputStream(fis);
			int size = datain.readInt();
			for (int i = 0; i < size; i++)
			{
				Machine machine = new Machine();
				machine.load(datain);
				machines.put(machine.getName(), machine);
			}
			finalMaterialsList.load(datain);
		}
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Factory && ((Factory) o).machines.equals(machines))
				&& ((Factory) o).finalMaterialsList.equals(finalMaterialsList);
	}

	public String getName()
	{
		return name;
	}

	public HashMap<String, Machine> getMachines()
	{
		return machines;
	}

	public MaterialsDestList getFinalMaterialsList()
	{
		return finalMaterialsList;
	}
}
