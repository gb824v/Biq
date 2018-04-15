package com.att.biq.day13.amir.recursion.binarytree;

public class Node<E extends Comparable<E>>
{
	enum SIDE
	{
		LEFT(0), RIGHT(1);
		private final int index;

		SIDE(int index)
		{
			this.index = index;
		}
	}

	// left and right
	private Node<E>[] nodes = new Node[2];
	private E value;

	Node(E val)
	{
		value = val;
	}

	public void add(Node<E> node)
	{
		if (node.value.compareTo(value) < 0)
		{
			go(SIDE.LEFT, node);
		}
		else
		{
			go(SIDE.RIGHT, node);
		}
	}

	private void go(SIDE side, Node<E> node)
	{
		if (nodes[side.index] == null)
		{
			nodes[side.index] = node;
		}
		else
		{
			nodes[side.index].add(node);
		}
	}

	public Node<E> search(Node<E> node, E value)
	{
			if (node.value.compareTo(value) == 0)
			{
				return node;
			}
			else if (node.value.compareTo(value) > 0)
			{
				return search(node.nodes[SIDE.LEFT.index], value);
			}
			else if (node.value.compareTo(value) < 0)
			{
				return search(node.nodes[SIDE.RIGHT.index], value);
			}
			return node;
	}

	private static String toString(Node<?> node)
	{
		if (node != null)
		{
			return node.toString();
		}
		return "";
	}

	@Override
	public String toString()
	{
		return toString(nodes[SIDE.LEFT.index]) + value + ", " + toString(nodes[SIDE.RIGHT.index]);
	}
}
