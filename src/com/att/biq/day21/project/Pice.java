package com.att.biq.day21.project;

import java.util.HashMap;

enum EnumSides
{
	TOP, BOTTOM, RIGHT, LEFT;
};

public class Pice
{
	public static int numOfElements = 0;
	private int id;
	private HashMap<EnumSides, Integer> pice = new HashMap<EnumSides, Integer>();

	public Pice(int id, HashMap<EnumSides, Integer> shape)
	{
		this.id = id;
		this.pice = shape;
		numOfElements++;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getBottom()
	{
		return pice.get(EnumSides.BOTTOM);
	}

	public int getTop()
	{
		return pice.get(EnumSides.TOP);
	}

	public int getLeft()
	{
		return pice.get(EnumSides.LEFT);
	}

	public int getRight()
	{
		return pice.get(EnumSides.RIGHT);
	}

	public static void main(String[] args)
	{
		HashMap<EnumSides, Integer> shape = new HashMap<>();
		shape.put(EnumSides.BOTTOM, 1);
		shape.put(EnumSides.TOP, -1);
		shape.put(EnumSides.RIGHT, 0);
		shape.put(EnumSides.LEFT, -1);
		Pice pice = new Pice(1, shape);
		System.out.println(pice.getTop());
		System.out.println(pice.getBottom());
		System.out.println(pice.getRight());
		System.out.println(pice.getLeft());
		System.out.println(pice.getId());
		System.out.println(Pice.numOfElements);
	}
}
