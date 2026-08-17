import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDemoKeyFrame extends JFrame implements KeyListener
{
	private JLabel label = new JLabel("Type some words below:");
	private JLabel output = new JLabel();
	private JTextField text = new JTextField(10);
	
	public JDemoKeyFrame()
	{
		super("KeyListener Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);
		add(output, BorderLayout.SOUTH);
		
		addKeyListener(this);
		text.addKeyListener(this);
	}
	public void keyTyped(KeyEvent e)
	{	
		char c = e.getKeyChar();
		output.setText("Last key typed: "+c);
	}
	public void keyPressed(KeyEvent e)
	{
		
	}
	public void keyReleased(KeyEvent e)
	{
		
	}
	public static void main(String[] args)
	{
		JDemoKeyFrame frame = new JDemoKeyFrame();
		final int WIDTH = 200;
		final int HEIGHT = 100;
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}

}
