import java.util.Scanner;

import javax.swing.JOptionPane;

public class CompareStrings {
	public static void main(String[] args)
	{
		String aName = "Ben";
		String anotherName;
		String aString;
		int anInteger = 8765;
		double myDouble = 8.45;
		String theString;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a name>>");
		anotherName = input.nextLine();
		
		if(aName.equals(anotherName)) //case sensitive
			System.out.println("aName and anotherName are equal.");
		else
			System.out.println("They are not equal.");
		
		if(aName.equalsIgnoreCase(anotherName))
			System.out.println("aName and anotherName are equal.");
		else
			System.out.println("They are not equal.");
		
		//using substring() method
		String name;
		String firstName = "";
		String familyName = "";
		int x;
		name = JOptionPane.showInputDialog(null,"Please enter customer's first and last name");
		x = 0;
		while(x < name.length())
		{
			if(name.charAt(x) == ' ')
			{
				firstName = name.substring(0, x);
				familyName = name.substring(x + 1, name.length());
				x = name.length();
			}
			++x;
		}
		JOptionPane.showMessageDialog(null,"Dear " + firstName +
				",\nI am so glad we are on a first name basis" +
				"\nbecause I would like the opportunity to" +
				"\ntalk to you about an affordable insurance" +
				"\nprotection plan for the entire " + familyName +
				"\nfamily. Call A-One Family Insurance today" +
				"\nat 1-800-555-9287.");
		
		//converting a primitive data type to string
		aString = Integer.toString(anInteger);
		theString = Double.toString(myDouble);
		//other string methods
		/*
		 * length()
		 * indexOf()
		 * charAt()
		 * endsWith() and startsWith()
		 * replace()
		 * substring() takes two arguments, start and finish positions
		 * regionMatches(), takes four or five arguments, start in string1, string2, start in string2,length of comparison
		 * for five arguments, case sensitivity(true means not), then the other four arguments
		 */
	}

}
