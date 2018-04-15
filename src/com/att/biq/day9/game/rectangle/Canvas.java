package com.att.biq.day9.game.rectangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Canvas extends JPanel
{
	private final ArrayList<Rectangle> myRecList;

	public Canvas(ArrayList<Rectangle> myRecList)
	{
		this.myRecList = myRecList;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(myRecList.get(0).getP1_x(), myRecList.get(0).getP1_y(), myRecList.get(0).getP2_x(),myRecList.get(0).getP2_y());
		g.setColor(Color.blue);
		g.fillRect(myRecList.get(1).getP1_x(), myRecList.get(1).getP1_y(), myRecList.get(1).getP2_x(),myRecList.get(1).getP2_y());
	}

}