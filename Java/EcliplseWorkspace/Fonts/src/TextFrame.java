
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TextFrame extends JFrame{
	public TextFrame(String text, String fontName){
		super("Show Font");
		setSize(425, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextFramePanel sf = new TextFramePanel(text, fontName);
		add(sf);
		setVisible(true);
	}
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage: Java TextFrame msg font");
			System.exit(-1);
		}
		TextFrame frame = new TextFrame(args[0], args[1]);
	}
}
