package com.att.biq.day20.exam;

public class IligalProductMachineException extends Exception
{
	private static final long serialVersionUID = 1L;

	public IligalProductMachineException(String machineName,String productName)
	{
		super("IligalProductMachineException: " + machineName + "->" + productName);
	}

}
