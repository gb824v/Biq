package com.att.biq.day10.test2.stack;

public class EmptyStackException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "";

	public EmptyStackException(String message)
	{
		super();
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

}
