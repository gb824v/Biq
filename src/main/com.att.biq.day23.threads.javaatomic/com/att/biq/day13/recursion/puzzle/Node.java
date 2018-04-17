package com.att.biq.day13.recursion.puzzle;

public class Node<E extends Comparable<E>>
{
	enum SIDE
	{
		LEFT(0), RIGHT(1), UP(2), DOWN(3);
		private final int index;

		SIDE(int index)
		{
			this.index = index;
		}
	}

	// left and right
	private Node<Boolean>[] nodes = new Node[4];
	public int coll, row;
	private boolean isFree;

	Node(boolean isFree)
	{
		this.isFree = isFree;
	}

	public Node<Boolean> go(Node<Boolean> node)
	{
		if (node.isFree)
		{
			System.out.println(node);
		}
		else if (node.nodes[SIDE.LEFT.index].isFree)
		{
			return go(node.nodes[SIDE.LEFT.index]);
		}
		else if (node.nodes[SIDE.RIGHT.index].isFree)
		{
			return go(node.nodes[SIDE.RIGHT.index]);
		}
		else if (node.nodes[SIDE.UP.index].isFree)
		{
			return go(node.nodes[SIDE.UP.index]);
		}
		else if (node.nodes[SIDE.DOWN.index].isFree)
		{
			return go(node.nodes[SIDE.DOWN.index]);
		}
		return node;
	}

	@Override
	public String toString()
	{
		return "coll: " + coll + ",row:" + row + "," + isFree;
	}
}
