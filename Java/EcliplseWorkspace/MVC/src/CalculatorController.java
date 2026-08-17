//The Controller coordinates interactions
//between the View and the Model

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel){
		this.theView = theView;
		this.theModel = theModel;
		
		//tell the View that whenever the calculate button is 
		//clicked, execute the actionPerformed method
		//in the  CalculateListener inner class
		
		this.theView.addCalculationListener(new CalculateListener());;
	}
	
	class CalculateListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			//surround interactions with the view with 
			//a try block in case numbers weren't 
			//properly entered
			
			try {
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				
				theModel.addTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue());
				
			}catch(NumberFormatException nfe) {
				
				System.out.println("Error: " + nfe.getMessage());
				theView.displayErrorMessage("You need to enter two numbers");
				
			}
		}
	}
}
