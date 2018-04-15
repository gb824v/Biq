package com.att.biq.day9.game.rectangle;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameScreen extends JFrame
{
	private static final long serialVersionUID = -8825602193680881820L;
	public static int WIDTH = 480;
	public static int HEIGHT = 480;

	public void play()
	{
		JFrame frame = new JFrame("InputDialog Example #2");
		String player1 = JOptionPane.showInputDialog(frame, "Enter your coordinates seperated by ,",
				"Playe1 your color is red", JOptionPane.WARNING_MESSAGE);

		String player2 = JOptionPane.showInputDialog(frame, "Enter your coordinates", "Playe2 your color is blue",
				JOptionPane.WARNING_MESSAGE);

		ArrayList<Rectangle> myRectangleList = new ArrayList<Rectangle>();

		Rectangle a = new Rectangle(player1.split(" "));
		Rectangle b = new Rectangle(player2.split(" "));
		myRectangleList.add(a);
		myRectangleList.add(b);

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerFrame();
		setVisible(true);
		Canvas myCanvas = new Canvas(myRectangleList);
		getContentPane().add(myCanvas);

		if (a.contains(b))
		{
			infoBox("Player 2 (blue) win!!", player2);

		}
		else
		{
			infoBox("Player 1 (red) win!!", player1);
		}
	}

	public void addRectangles(ArrayList<Rectangle> myRectangleList)
	{
		Canvas myCanvas = new Canvas(myRectangleList);
		getContentPane().add(myCanvas);
	}

	private void centerFrame()
	{

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}

	public static void infoBox(String infoMessage, String titleBar)
	{
		JOptionPane.showMessageDialog(null, infoMessage, "The Winner is: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
}
