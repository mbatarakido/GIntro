import java.util.Scanner;

import javax.swing.JOptionPane;

public class TestCharacter {
	private static final char YES_OPTION = 'y';

	public static void main(String[] args)
	{
		char aChar;
		String aString;
		char entryChar;
		int count = 0;
		String entryString;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a character --");
		aString = keyboard.nextLine();
		aChar = aString.charAt(0);
		System.out.println("The character is "+aChar);
		
		if(Character.isUpperCase(aChar))
			System.out.println(aChar+" is uppercase.");
		else
			System.out.println(aChar+" is not uppercase.");
		if(Character.isLowerCase(aChar))
			System.out.println(aChar+" is lowercase.");
		else
			System.out.println(aChar+" is not lowercase.");
		
		aChar = Character.toLowerCase(aChar);
		System.out.println("After toLowerCase() aChar is "+aChar);
		aChar = Character.toUpperCase(aChar);
		System.out.println("After toUpperCase() aChar is "+aChar);
		
		if(Character.isLetterOrDigit(aChar))
			System.out.println(aChar+" is letter or digit.");
		else
			System.out.println(aChar+" is neither letter nor digit.");
		if(Character.isWhitespace(aChar))
			System.out.println(aChar+" is a whitespace.");
		else
			System.out.println(aChar+" is not a whitespace.");
		
		do
		{
			++count;
			entryString = JOptionPane.showInputDialog(null,
					"Greeting #" + count +
					" Hello!\nDo you want to see another greeting?");
			entryChar = entryString.charAt(0);
		}while(Character.toLowerCase(entryChar) == YES_OPTION);

	}

}
