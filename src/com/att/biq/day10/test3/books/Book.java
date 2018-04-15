package com.att.biq.day10.test3.books;

public class Book implements Comparable<Book>
{
	private String name;
	private String author;
	private long catalogNumber;

	public Book(String name, String author, long catalogNumber)
	{
		super();
		this.name = name;
		this.author = author;
		this.catalogNumber = catalogNumber;
	}

	@Override
	public int compareTo(Book book)
	{
		int compareName = name.compareTo(book.getName());
		int compareAuthor = author.compareTo(book.getAuthor());
		return compareName == 0 ? compareAuthor : compareName;
	}

	@Override
	public boolean equals(Object o)
	{
		return (o instanceof Book && ((Book) o).catalogNumber == this.catalogNumber);
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public long getCatalogNumber()
	{
		return catalogNumber;
	}

	public void setCatalogNumber(long catalogNumber)
	{
		this.catalogNumber = catalogNumber;
	}

	@Override
	public String toString()
	{
		return "Book:" + name + " Author:" + author +  " CatalogNumber:" + catalogNumber;
	}
}
