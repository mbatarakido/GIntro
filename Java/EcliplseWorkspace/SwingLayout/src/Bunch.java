
import java.awt.*;
import javax.swing.*;
public class Bunch extends JFrame{
	public Bunch() {
		super("Bunch");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		GridLayout family = new GridLayout(3, 3, 0, 10);
		pane.setLayout(family);
		JButton marcia = new JButton("Marcia");
		JButton carol = new JButton("Carol");
		JButton greg = new JButton("Greg");
		JButton jan = new JButton("Jan");
		JButton alice = new JButton("Alice");
		JButton peter = new JButton("Peter");
		JButton cindy = new JButton("Cindy");
		JButton mike = new JButton("Mike");
		JButton bobby = new JButton("Bobby");
		pane.add(marcia);
		pane.add(carol);
		pane.add(greg);
		pane.add(jan);
		pane.add(alice);
		pane.add(peter);
		pane.add(cindy);
		pane.add(mike);
		pane.add(bobby);
		add(pane);
		setVisible(true);
	}
	public static void main(String[] args) {
		Bunch frame = new Bunch();
	}
}
