package parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	private int expected;
	private int first;
	private int second;
	public ParameterTest(int expected,int first,int second) {
		this.expected = expected;
		this.first = first;
		this.second = second;
	}

@Parameters
public static Collection addNumbers()
{
	return Arrays.asList(new Integer[][] {{5,2,3},{11,5,6},{17,8,9}});
}

@Test
public void sum()
{
	Calculator cal = new Calculator();
	System.out.println(first+"+"+second+"="+expected);
	assertEquals(expected,cal.add(first,second));
	
}
}








