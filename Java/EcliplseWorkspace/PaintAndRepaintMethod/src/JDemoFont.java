import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class JDemoFont extends JFrame{
	Font bigFont = new Font("Serif",Font.ITALIC,36);
	String hello = "Hello";
	public void paint(Graphics brush)
	{
		super.paint(brush);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		brush.setFont(bigFont);
		brush.setColor(Color.BLUE);
		brush.drawString(hello, 10, 60);
		brush.drawLine(60, 80, 150, 250);
	}
	public static void main(String[] args)
	{
		JDemoFont frame = new JDemoFont();
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
