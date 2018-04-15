package com.att.biq.day8.abstruct;

import java.awt.Graphics;

public class BouncingPoint extends Point
{
	public BouncingPoint(int x, int y, Direction direction, Graphics graphics)
	{
		super(x, y, direction, graphics);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move()
	{
		switch (getDirection())
		{
		case UP:
			if ((getX() - getSteps()) < 0)
			{
				setX(0);
				setDirection(Direction.LEFT);
			}
			super.move();
			break;
		default:
			super.move();
			break;
		}
	}
}
