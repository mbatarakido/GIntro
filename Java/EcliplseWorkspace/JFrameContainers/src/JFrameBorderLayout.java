import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameBorderLayout extends JFrame{
	private JButton nb = new JButton("North Button");
	private JButton sb = new JButton("South Button");
	private JButton eb = new JButton("East Button");
	private JButton wb = new JButton("West Button");
	private JButton cb = new JButton("Center Button");
	private Container con = getContentPane();
	
	public JFrameBorderLayout()
	{
		super("Border Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(new BorderLayout());
		con.setBackground(Color.RED);
		con.add(nb, BorderLayout.NORTH);
		con.add(sb, BorderLayout.SOUTH);
		con.add(eb, BorderLayout.EAST);
		con.add(wb, BorderLayout.WEST);
		con.add(cb, BorderLayout.CENTER);
		cb.setBackground(Color.BLACK);
		cb.setForeground(Color.BLUE);
		setSize(450,150);
	}
	public static void main(String[] args)
	{
		JFrameBorderLayout bFrame = new JFrameBorderLayout();
		bFrame.setVisible(true);
	}

}
