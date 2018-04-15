package com.att.biq.day10.test3.books;

public class BookInstance
{
	Book book;
	int instanceId = 0;
	
	public BookInstance(Book book,int instanceId)
	{
		this.book = book;
		this.instanceId = instanceId;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public int getInstanceId()
	{
		return instanceId;
	}

	public void setInstanceId(int instanceId)
	{
		this.instanceId = instanceId;
	}
	@Override
	public String toString()
	{
		return "BookInstance:" + instanceId + " ";
	}
}
