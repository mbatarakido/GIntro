import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JDemoFlowLayout extends JFrame implements ActionListener{
	private JButton lb = new JButton("L Button");
	private JButton rb = new JButton("R Button");
	private Container con = getContentPane();
	private FlowLayout layout = new FlowLayout();
	public JDemoFlowLayout()
	{
		super("Alignment Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(layout);
		con.add(lb);
		con.add(rb);
		lb.addActionListener(this);
		rb.addActionListener(this);
		setSize(500, 100);
	}
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		if(source == lb)
			layout.setAlignment(FlowLayout.LEFT);
		else
			layout.setAlignment(FlowLayout.RIGHT);
		con.invalidate();
		con.validate();
	}
	public static void main(String[] args)
	{
		JDemoFlowLayout frame = new JDemoFlowLayout();
		frame.setVisible(true);
	}

}
