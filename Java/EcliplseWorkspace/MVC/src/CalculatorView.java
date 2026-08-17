//The is the View
//It's only job is to display what the user sees
//It performs no calculations, but instead passes
//information entered by the user to whoever needs it

import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame {
	
	private JTextField fNum = new JTextField(5);
	private JLabel additionLabel = new JLabel("+");
	private JTextField sNum = new JTextField(5);
	private JButton calcButton = new JButton("=");
	private JTextField calcSolution = new JTextField(5);
	
	CalculatorView(){
		
		//sets up the view and adds the components
		
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 200);
		
		panel.add(fNum);
		panel.add(additionLabel);
		panel.add(sNum);
		panel.add(calcButton);
		panel.add(calcSolution);
		
		this.add(panel);
		
		//end of setting up the components...
	}
	public int getFirstNumber() {
		return Integer.parseInt(fNum.getText());
	}
	public int getSecondNumber() {
		return Integer.parseInt(sNum.getText());
	}
	public int getCalcSolution() {
		return Integer.parseInt(calcSolution.getText());
	}
	public void setCalcSolution(int solution) {
		calcSolution.setText(Integer.toString(solution));
	}
	
	//If the calcButton is clicked execute a method in 
	//the Controller named actionPerformed
	
	void addCalculationListener(ActionListener listenForCalcButtton) {
		calcButton.addActionListener(listenForCalcButtton);
	}
	
	//open a pop up that contains the error message passed
	//if user entry is insufficient
	
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
			
}
