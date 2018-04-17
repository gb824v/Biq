package com.att.biq.day20.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Machine
{
	private String name;
	private final MaterialsList materialInSchema = new MaterialsList();
	private final MaterialsDestList materialOutSchema = new MaterialsDestList();
	private MaterialsList materialsTotal = new MaterialsList();

	public Machine(String name)
	{
		this.name = name;
	}

	public Machine()
	{
	}

	public boolean checkIfnoughInputMaterials() throws NotEnoughInputMaterialsException
	{
		if (!materialsTotal.containSubList(materialInSchema))
		{
			throw new NotEnoughInputMaterialsException();
		}
		return true;
	}

	public MaterialsDestList doWork()
	{
		if (materialsTotal.containSubList(materialInSchema))
		{
			materialsTotal.removeSubList(materialInSchema);
			return materialOutSchema;
		}
		else
		{
			return null;
		}
	}

	public void add2InSchema(MaterialEnum name, int amount)
	{
		materialInSchema.add(name, amount);
	}

	public void pushMaterial(MaterialEnum name, int amount)
	{
		materialsTotal.add(name, amount);
	}

	public void add2OutSchema(Material material)
	{
		this.materialOutSchema.add(material);
	}

	public void add2OutSchema(Material material, Machine machineDestination)
	{
		this.materialOutSchema.add(material, machineDestination);
	}

	public void save(DataOutputStream dataOut) throws IOException
	{
		dataOut.writeUTF(name);
		materialInSchema.save(dataOut);
		materialOutSchema.save(dataOut);
		materialsTotal.save(dataOut);
	}

	public void load(DataInputStream datain) throws IOException
	{
		name = datain.readUTF();
		materialInSchema.load(datain);
		materialOutSchema.load(datain);
		materialsTotal.load(datain);
	}

	public String getName()
	{
		return name;
	}

	public MaterialsList getMaterialInSchema()
	{
		return materialInSchema;
	}

	public MaterialsDestList getMaterialOutSchema()
	{
		return materialOutSchema;
	}

	public MaterialsList getMaterialsTotal()
	{
		return materialsTotal;
	}

}
