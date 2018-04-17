package com.att.biq.day13.amir.recursion.binarytree;

public class TreeMain
{

	public static void main(String[] args)
	{
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.add(540);
		tree.add(1080);
		tree.add(120);
		tree.add(640);
		tree.add(2023);
		tree.add(60);
		tree.add(240);
		tree.add(35);
		tree.add(180);
		tree.add(670);
		Node node = tree.search(670);
		System.out.println(node);

		BinaryTree<String> tree2 = new BinaryTree<>();
		tree2.add("Hello");
		tree2.add("world");
		tree2.add("how");
		tree2.add("are");
		tree2.add("you");
		tree2.add("doing");
		tree2.add("today");
		System.out.println(tree2);
		
		
	}

}
