package com.att.biq.day9.game.rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class Rectangle extends JPanel
{
	private Point p1 = null;
	private Point p2 = null;

	public Rectangle(Point p1, Point p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}

	public Rectangle(String[] params)
	{
		if (params.length >= 2)
		{
			p1.setX(Math.min(Integer.parseInt(params[0]), Integer.parseInt(params[2])));
			p1.setY(Math.min(Integer.parseInt(params[1]), Integer.parseInt(params[3])));
			p2.setX(Math.max(Integer.parseInt(params[0]), Integer.parseInt(params[2])));
			p2.setY(Math.max(Integer.parseInt(params[1]), Integer.parseInt(params[3])));
		}
	}

	public boolean contains(Rectangle rec)
	{
		return (p1.getX() <= rec.getP1_x()) && (rec.getP2_x() <= getP2_x()) && (getP2_y() <= rec.getP1_y())
				&& (rec.getP2_y() <= getP2_y());
	}

	public int area()
	{
		return Math.abs((p1.getX() - p2.getX()) * (p1.getY() - p2.getY()));
	}

	public int scale()
	{
		return Math.abs((2 * (p1.getX() - p2.getX())) + (2 * (p1.getY() - p2.getY())));
	}

	public int getP1_x()
	{
		return p1.getX();
	}

	public int getP2_x()
	{
		return p2.getX();
	}

	public int getP1_y()
	{
		return p1.getY();
	}

	public int getP2_y()
	{
		return p2.getY();
	}
}