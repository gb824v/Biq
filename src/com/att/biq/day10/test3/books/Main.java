package com.att.biq.day10.test3.books;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		Library l = new Library();
		Book bookA = new Book("Book-A", "Autor-A", 1);
		BookInstance bookAInstance1 = new BookInstance(bookA, 1);
		BookInstance bookAInstance2 = new BookInstance(bookA, 2);
		BookInstance bookAInstance3 = new BookInstance(bookA, 3);
		BookInstance bookAInstance4 = new BookInstance(bookA, 4);

		Book bookB = new Book("Book-B", "Autor-B", 2);
		BookInstance bookBInstance1 = new BookInstance(bookB, 1);
		BookInstance bookBInstance2 = new BookInstance(bookB, 2);
		BookInstance bookBInstance3 = new BookInstance(bookB, 3);
		BookInstance bookBInstance4 = new BookInstance(bookB, 4);

		ArrayList<BookInstance> bookAInstances = new ArrayList<BookInstance>();
		bookAInstances.add(bookAInstance1);
		bookAInstances.add(bookAInstance2);
		bookAInstances.add(bookAInstance3);
		bookAInstances.add(bookAInstance4);

		ArrayList<BookInstance> bookBInstances = new ArrayList<BookInstance>();
		bookBInstances.add(bookBInstance1);
		bookBInstances.add(bookBInstance2);
		bookBInstances.add(bookBInstance3);
		bookBInstances.add(bookBInstance4);

		Borrower borrower = new Borrower("Guy", 12356);
		borrower.addBookInstance(bookAInstance3);
		borrower.addBookInstance(bookAInstance1);
		borrower.addBookInstance(bookAInstance2);

		l.addBookInstance(bookA, bookAInstances);
		l.addBookInstance(bookB, bookBInstances);
		l.addBorrower(borrower);

		ApplyOnBorrower applyOnBorrowerObj = new ApplyOnBorrower()
		{
			@Override
			public void applyFunction(Borrower b)
			{
				System.out.println(b);

			}
		};
		l.forAllBorrowers(applyOnBorrowerObj);
	}
}
