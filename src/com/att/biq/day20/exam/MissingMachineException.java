package com.att.biq.day20.exam;

public class MissingMachineException extends Exception
{
	private static final long serialVersionUID = 1L;

	public MissingMachineException(String machineName)
	{
		super(machineName + " is Missing");
	}

}
