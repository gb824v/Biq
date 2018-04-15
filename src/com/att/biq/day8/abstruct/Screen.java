package com.att.biq.day8.abstruct;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.att.biq.day8.abstruct.Point.Direction;

public class Screen extends JFrame implements ActionListener, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = WIDTH / 16 * 9;
	static Point tunnelPoint;

	public Screen()
	{
		Graphics graphics = null;
		BufferStrategy bufferStrategy = null;
		addKeyListener(this);
		tunnelPoint = new TunnelPoint(5, 15, Direction.RIGHT, graphics);
		final String title = "Point Window";
		// Creating the frame.
		setTitle(title);

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		// Creating the canvas.
		Canvas canvas = new Canvas();

		canvas.setSize(WIDTH, HEIGHT);
		canvas.setBackground(Color.BLACK);
		canvas.setVisible(true);
		canvas.setFocusable(false);
		// Putting it all together.
		add(canvas);
		canvas.createBufferStrategy(3);
		bufferStrategy = canvas.getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
		tunnelPoint.setGraphics(graphics);
		graphics.setColor(Color.GREEN);
		bufferStrategy.show();
		graphics.dispose();
	}

	@Override
	public void keyPressed(KeyEvent event)
	{
	}

	@Override
	public void keyReleased(KeyEvent event)
	{
		switch (event.getKeyChar())
		{
		case KeyEvent.VK_RIGHT:
			tunnelPoint.setDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_LEFT:
			tunnelPoint.setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_UP:
			tunnelPoint.setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			tunnelPoint.setDirection(Direction.DOWN);
			break;
		default:
			break;
		}
		tunnelPoint.move();

	}

	@Override
	public void keyTyped(KeyEvent event)
	{

	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}
}
