import java.awt.Graphics;

import javax.swing.JFrame;

public class JDemoStar extends JFrame{
	public void paint(Graphics gr)
	{
		super.paint(gr);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int xPoints[] = {42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42};
		int yPoints[] = {38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38};
		//gr.fillPolygon(xPoints, yPoints, xPoints.length);
		gr.drawPolygon(xPoints, yPoints, xPoints.length);
		gr.copyArea(0, 0, 120, 130, 100, 50);

	}
	public static void main(String[] args)
	{
		JDemoStar frame = new JDemoStar();
		frame.setSize(820, 250);
		frame.setVisible(true);
	}

}
