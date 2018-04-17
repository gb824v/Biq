package com.att.biq.day10.test2.stack;

public class FullStackException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "";

	public FullStackException(String message)
	{
		super();
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

}
