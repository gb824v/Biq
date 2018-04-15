package com.att.biq.day8.abstruct;

import java.awt.Graphics;

public abstract class Point
{
	private int steps = 1;
	private int x;
	private int y;
	private Direction direction;
	private final String charToPaint = "*";
	Graphics graphics;

	public enum Direction
	{
		RIGHT, LEFT, UP, DOWN
	}

	// point initialized from parameters
	public Point(int x, int y, Direction direction,Graphics graphics)
	{
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.graphics = graphics;
	}

	public int x()
	{
		return x;
	}

	public int y()
	{
		return y;
	}

	public void move()
	{
		graphics.clearRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
		switch (direction)
		{
		case UP:
			if ((x - steps) > 0)
				x -= steps;
			break;
		case LEFT:
			if ((y - steps) > 0)
				y -= steps;
			break;
		case DOWN:
			if ((y + steps) < Screen.HEIGHT)
				y += steps;
			break;
		case RIGHT:
			if ((x + steps) < Screen.WIDTH)
				x += steps;
			break;
		default:
			break;
		}
		this.graphics.drawString(charToPaint, x, y);
	}

	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}

	public int getSteps()
	{
		return steps;
	}

	public void setSteps(int steps)
	{
		this.steps = steps;
	}

	public Direction getDirection()
	{
		return direction;
	}

	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public Graphics getGraphics()
	{
		return graphics;
	}

	public void setGraphics(Graphics graphics)
	{
		this.graphics = graphics;
	}
	
}