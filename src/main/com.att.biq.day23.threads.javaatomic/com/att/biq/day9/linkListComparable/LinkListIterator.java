package com.att.biq.day9.linkListComparable;

import java.util.Iterator;

public class LinkListIterator implements Iterator<Node>
{
	private Node node;

	public LinkListIterator(Node headNode)
	{
		Node nodeTemp = new Node("");
		nodeTemp.setNext(headNode);
		this.node = nodeTemp;
	}

	@Override
	public boolean hasNext()
	{
		return (node.getNext() != null);
	}

	@Override
	public Node next()
	{
		Node nextNode = node.getNext();
		this.node = nextNode;
		return nextNode;
	}
}
