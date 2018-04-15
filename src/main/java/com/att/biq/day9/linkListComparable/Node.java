package com.att.biq.day9.linkListComparable;

public class Node implements Comparable<Object>
{

	private Object data = null;
	private Node next = null;

	public <T> Node(T data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return data.toString();
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	@Override
	public int compareTo(Object obj)
	{
		return ((Node) data).compareTo((Node) obj);
	}

}
