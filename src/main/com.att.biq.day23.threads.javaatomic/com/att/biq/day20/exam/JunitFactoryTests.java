package com.att.biq.day20.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Factory Junit Tests")
public class JunitFactoryTests
{
	Machine machineA;
	@Before
	public void before()
	{
		machineA = new Machine("A");
		machineA.add2InSchema(MaterialEnum.SHALBUK, 10);
		machineA.add2InSchema(MaterialEnum.TALPAZ, 5);
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("D"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));
	}
	@Test
	@DisplayName("Machine - negative case: not enough input materials products nothing")
	public void notEnoughInputMaterials()
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("D"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		MaterialsDestList materialOutputSchemaRes = machineA.doWork();
		assertEquals(materialOutputSchemaRes, null);
	}

	@Test
	@DisplayName("Machine - happy path: enough input materials products output materials as expected")
	public void enoughInputMaterials()
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("D"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.TALPAZ, 5);
		MaterialsDestList materialOutSchemaActual = machineA.getMaterialOutSchema();
		MaterialsDestList materialOutputSchemaRes = machineA.doWork();
		assertEquals(materialOutputSchemaRes, materialOutSchemaActual);
	}

	@Test
	@DisplayName("Factory - Save and load data from bin file")
	public void saveAndLoadDataFromBinFile() throws IOException
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("D"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.TALPAZ, 5);
		Factory factory = new Factory("Amir Factory");
		factory.addMachine(machineA);
		File factoryBinFile = File.createTempFile("factory", ".bin");
		System.out.println("Saving to: " + factoryBinFile.getAbsolutePath());
		factory.save(factoryBinFile);
		Factory factoryB = factory;
		factory.load(factoryBinFile);
		assertEquals(factory, factoryB);
		factoryBinFile.delete();
	}

	@Test
	@DisplayName("Factory Flow - test a flow on a factory with two machines")
	public void flowOnFactoryWith2Machines() throws IligalProductMachineException
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("B"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5), new Machine("B"));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.TALPAZ, 5);

		Machine machineB = new Machine("B");
		machineB.add2InSchema(MaterialEnum.SHALBUK, 3);
		machineB.add2InSchema(MaterialEnum.PLANCHA, 5);
		machineB.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3));
		machineB.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));

		Factory factory = new Factory("Amir Factory");
		factory.addMachine(machineA);
		factory.addMachine(machineB);
		MaterialsDestList finalMaterialsList;
		try
		{
			finalMaterialsList = factory.doWork(3);
			assertEquals(finalMaterialsList.size(), 2);
		}
		catch (MissingMachineException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("Factory Flow - test missing machine exception")
	public void missingmachine() throws MissingMachineException
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("D"));
		machineA.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5), new Machine("D"));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.TALPAZ, 5);

		Machine machineB = new Machine("B");
		machineB.add2InSchema(MaterialEnum.SHALBUK, 3);
		machineB.add2InSchema(MaterialEnum.PLANCHA, 5);
		machineB.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3));
		machineB.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));

		Factory factory = new Factory("Amir Factory");
		factory.addMachine(machineA);
		factory.addMachine(machineB);

		assertThrows(MissingMachineException.class, () ->
		{
			factory.doWork(3);
		});

	}
	@Test
	@DisplayName("Factory Flow - test missing machine exception")
	public void iligalProduct() throws MissingMachineException
	{
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3), new Machine("B"));
		machineA.add2OutSchema(new Material(MaterialEnum.SHALBUK, 5), new Machine("B"));
		machineA.pushMaterial(MaterialEnum.SHALBUK, 10);
		machineA.pushMaterial(MaterialEnum.TALPAZ, 5);

		Machine machineB = new Machine("B");
		machineB.add2InSchema(MaterialEnum.SHALBUK, 3);
		machineB.add2InSchema(MaterialEnum.PLANCHA, 5);
		machineB.add2OutSchema(new Material(MaterialEnum.SHALBUK, 3));
		machineB.add2OutSchema(new Material(MaterialEnum.PLANCHA, 5));

		Factory factory = new Factory("Amir Factory");
		factory.addMachine(machineA);
		factory.addMachine(machineB);

		assertThrows(IligalProductMachineException.class, () ->
		{
			factory.doWork(3);
		});
	}
}
