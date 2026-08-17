import javax.swing.JFrame;

public class JMyFrame extends JFrame
{
	final int WIDTH = 350;
	final int HEIGHT = 300;
	public JMyFrame()
	{
		super("My Frame");
		setSize(WIDTH,HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
