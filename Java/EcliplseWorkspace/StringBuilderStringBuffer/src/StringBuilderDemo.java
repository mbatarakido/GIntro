
public class StringBuilderDemo {
	public static void main(String[] args)
	{
		StringBuilder nameString = new StringBuilder("Barbara");
		int nameStringCapacity = nameString.capacity();
		
		System.out.println("nameString capacity = "+nameStringCapacity);
		
		StringBuilder addressString = null;
		addressString = new StringBuilder("6311 Street Park Avenue");
		int addStringCapacity = addressString.capacity();
		
		System.out.println("Capacity of addressString = "+addStringCapacity);
		
		nameString.setLength(10);
		
		System.out.println("The name is "+nameString+" end.");
		
		addressString.setLength(10);
		
		System.out.println("The address is "+addressString);
		
		//to compare objects using equals() in StringBuilders first convert to string e.g
		//obj1.toString().equals(obj2.toString());
		
		StringBuilder phrase =new StringBuilder("Happy");
		phrase.append(" birthday");
		System.out.println("The phrase is..."+phrase);
		phrase.insert(6, "30th ");
		System.out.println("The new phrase is..."+phrase);
		phrase.setCharAt(6, '4');
		System.out.println("Now the phrase is..."+phrase);
		char ch = phrase.charAt(14);
		System.out.println(ch);
	}

}
