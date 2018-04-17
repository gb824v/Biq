package com.att.biq.day10.test3.books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library
{
	// Map of Book to List<BookInstance>
	private Map<Book, ArrayList<BookInstance>> bookMapList = new HashMap<Book, ArrayList<BookInstance>>();
	// Map of Borrower id to List<BookInstance>
	private ArrayList<Borrower> borrowerList = new ArrayList<Borrower>();

	public void addBorrower(Borrower borrower)
	{
		borrowerList.add(borrower);
	}

	public void addBookInstance(Book book, ArrayList<BookInstance> bookInstances)
	{
		bookMapList.put(book, bookInstances);
	}

	public void forAllBorrowers(ApplyOnBorrower apply)
	{
		for (Borrower borrowerMap : borrowerList)
		{
			apply.applyFunction(borrowerMap);
		}
	}
}
