package com.att.biq.day9.linkListComparable;

import java.util.Iterator;

public class LinkList<T> implements Iterable<Node>
{
	private Node headNode;
	private Node lastNode;
	private int size = 0;

	@Override
	public String toString()
	{
		String str = "";
		if (headNode != null)
		{
			Node tempNode = headNode;
			while (tempNode.getNext() != null)
			{
				str += tempNode + "-> ";
				tempNode = tempNode.getNext();
			}
			str += tempNode;

		}
		return str;
	}

	public void add(T obj)
	{
		Node newNode = new Node(obj);

		if (headNode == null)
		{
			headNode = newNode;
			lastNode = newNode;
		}
		else
		{
			lastNode.setNext(newNode);
			newNode.setNext(null);
			lastNode = newNode;

		}
		size++;
	}

	public int size()
	{
		return size;
	}

	public void clear()
	{
		size = 0;
		headNode = null;
		lastNode = null;
	}

	public Node find(T obj)
	{
		Node tempNode = headNode;

		while (tempNode != null)
		{
			if (tempNode.getData().equals(obj))
			{
				return tempNode;
			}
			else
			{
				tempNode = tempNode.getNext();
			}
		}
		return null;
	}

	public void remove(T obj)
	{
		Node tempNode = headNode;
		Node prevNode = headNode;

		while (tempNode != null)
		{
			if (tempNode.getData().equals(obj))
			{
				if (tempNode.equals(headNode))
				{
					headNode = tempNode.getNext();
				}
				else if (tempNode.equals(lastNode))
				{
					prevNode.setNext(null);
					lastNode = prevNode;
				}
				else
				{
					prevNode.setNext(tempNode.getNext());
				}
				size--;
				break;
			}
			else
			{
				prevNode = tempNode;
				tempNode = tempNode.getNext();
			}
		}

	}

	public void dellAllDuplicateName()
	{
		Node ptr1 = headNode;
		Node ptr2 = headNode;
		Node dump = headNode;
		while (ptr1 != null && ptr1.getNext() != null)
		{
			ptr2 = ptr1;
			while (ptr2.getNext() != null)
			{
				if (((Person)ptr1.getData()).getName().equals(((Person)ptr2.getNext().getData()).getName()))
				{
					dump = ptr2.getNext();
					ptr2.setNext(ptr2.getNext().getNext());
					remove((T) dump);
					System.out.println("remove:" + dump.getData());
					size--;

				}
				else
				{
					ptr2 = ptr2.getNext();
				}
			}
			ptr1 = ptr1.getNext();
		}
	}

	public Node getHeadNode()
	{
		return headNode;
	}

	public Node getLastNode()
	{
		return lastNode;
	}

	@Override
	public Iterator<Node> iterator()
	{
		 return new LinkListIterator(headNode);
	}
}
