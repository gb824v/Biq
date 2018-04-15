package com.att.biq.day8.abstruct;

import java.awt.Graphics;

public class TunnelPoint extends Point
{
	public TunnelPoint(int x, int y, Direction direction, Graphics graphics)
	{
		super(x, y, direction, graphics);
	}

	@Override
	public void move()
	{
		switch (getDirection())
		{
		case UP:
			if ((super.getX() - super.getSteps()) < 0)
			{
				super.setX(0);
				super.setDirection(Direction.RIGHT);
			}
			super.move();
			break;
		default:
			super.move();
			break;
		}
	}

}
