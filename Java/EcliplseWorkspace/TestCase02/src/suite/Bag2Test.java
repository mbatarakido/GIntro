package suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Bag2Test {
	String[] bag = {"Books","Notebooks","Pens"};
	Bag2 b2 = new Bag2();

	@Test
	public void testGetBag() {
		System.out.println("Inside testGetBag()");
		assertArrayEquals(bag,b2.getBag());
		
	} 
}
