package com.att.biq.day13.recursion.puzzle;

public class Puzzle<E extends Comparable<Boolean>>
{

	Node<Boolean> root;

	public void go()
	{
		if (root != null)
		{
			root.go(root);
		}
	}

	@Override
	public String toString()
	{
		return "[" + (root != null ? root.toString() + "\b\b" : "") + "]";
	}
}
