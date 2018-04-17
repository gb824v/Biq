package com.att.biq.day10.test3.books;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Borrower extends Person
{
	private Map<BookInstance, Date> borrowerBooks = new HashMap<BookInstance, Date>();

	public Borrower(String name, int id)
	{
		super(name, id);
	}

	public void addBookInstance(BookInstance bookInstance)
	{
		borrowerBooks.put(bookInstance, new Date());
	}

	public void removeBookInstance(BookInstance bookInstance)
	{
		borrowerBooks.remove(bookInstance);
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		
		s.append( "Borrower:" + super.toString() +  " borrow " +  borrowerBooks.size() + " books:\n");

		for (Entry<BookInstance, Date> entry : borrowerBooks.entrySet())
		{
			s.append(entry.getKey() +  " " + entry.getKey().getBook() + " Date:" + entry.getValue().toString() + "\n");
		}

		return s.toString();

	}
}
