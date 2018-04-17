package com.att.biq.day13.amir.recursion.binarytree;

public class BinaryTree<E extends Comparable<E>>
{

	Node<E> root;

	public void add(E val)
	{
		Node<E> newNode = new Node<>(val);
		if (root == null)
		{
			root = newNode;
		}
		else
		{
			root.add(newNode);
		}
	}

	public Node<E> search(E val)
	{
		Node<E> node = null;
		if (root != null)
		{
			node = root.search(root,val);
		}
		return node;
	}

	@Override
	public String toString()
	{
		return "[" + (root != null ? root.toString() + "\b\b" : "") + "]";
	}
}
