package com.att.biq.day11.test3.stackiterator;

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
