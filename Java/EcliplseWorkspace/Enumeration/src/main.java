import java.util.EnumSet;
import java.util.Scanner;

public class main {
	
	enum Month {JAN, FEB, MAR, APR, MAY, JUN,
		JUL, AUG, SEP, OCT, NOV, DEC};
		
	enum Property {SINGLE_FAMILY, MULTIPLE_FAMILY,
		CONDOMINIUM, LAND, BUSINESS};
		
	public static void main(String[] args) {
		for(people names: people.values())
			System.out.printf("%s\t%s\t%s\n",names,names.getDesc(),names.getYear());
		
		System.out.println("\nAnd now for the range of constants!!!");
		
		for(people names: EnumSet.range(people.kelsey, people.candy))
			System.out.printf("%s\t%s\t%s\n",names,names.getDesc(),names.getYear());
		
		//enum of months
		Month birthMonth;
		String userEntry;
		int position;
		int comparison;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\n");
		System.out.println("The months are:");
		for(Month mon : Month.values())
			System.out.print(mon + " ");
		System.out.print("\n\nEnter the first three letters of " +
				"your birth month >> ");
		userEntry = input.nextLine().toUpperCase();
		birthMonth = Month.valueOf(userEntry);
		System.out.println("You entered " + birthMonth);
		
		position = birthMonth.ordinal();
		System.out.println(birthMonth + " is in position " + position);
		System.out.println("So its month number is " + (position + 1));
		
		comparison = birthMonth.compareTo(Month.JUN);
		if(comparison < 0)
			System.out.println(birthMonth +
					" is earlier in the year than " + Month.JUN);
		else if(comparison > 0)
			System.out.println(birthMonth +
					" is later in the year than " + Month.JUN);
		else
			System.out.println(birthMonth + " is " + Month.JUN);
		
		//enum of real estate property
		Property propForSale = Property.MULTIPLE_FAMILY;
		switch(propForSale)
		{
			case SINGLE_FAMILY:
			case MULTIPLE_FAMILY:
				System.out.println("Listing fee is 5%");
				break;
			case CONDOMINIUM:
				System.out.println("Listing fee is 6%");
				break;
			case LAND:
			case BUSINESS:
				System.out.println("We do not handle this type of property");
		}
	}

}
