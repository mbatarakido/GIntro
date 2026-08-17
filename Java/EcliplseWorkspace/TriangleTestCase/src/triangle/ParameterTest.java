package triangle;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	static String expected;
	private static int a;
	private static int b;
	private static int c;

	static Scanner console = new Scanner(System.in);
		public static void main(String args[]) 
		{
			//int a,b,c;
			
			System.out.println("Enter a b and c: ");
			a = console.nextInt();
			b = console.nextInt();
			c = console.nextInt();
			System.out.println("The values are: "+a+" "+b+" "+c);
			
		}
	
	@Parameters
	public static String display()
	{
		
		if((1<=a&&a<=100) && (1<=b&&b<=100) &&(1<=c&&c<=100)) 
		{
			// function calling and print output 
			if ((Triangle.isValid(a, b, c)) == 1) 
			{
				System.out.println("Valid"); 
				expected = "Valid";
			  	return expected;
			}
			else
			{
				System.out.println("Invalid");
				expected = "Invalid";
				return expected;
			}

		}
		return expected;
	}
	@Test
	public void triangle()
	{
		System.out.println("Sides "+a+" "+b+" "+c+" are "+expected);
		assertEquals(expected,Triangle.isValid(a,b,c));
	}

}
