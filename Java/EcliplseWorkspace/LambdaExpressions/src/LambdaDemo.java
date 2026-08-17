
@FunctionalInterface
interface BinaryCalculator{
	double calculator(double val1, double val2);
}
@FunctionalInterface
interface UnaryCalculator{
	double calculator(double val);
}
public class LambdaDemo {
	public static void main(String[] args) {
		new Thread(()->System.out.println("Lambda Calculator Expression")).start();
		
		System.out.printf("18 + 36.5 = %f%n", calculate((double v1, double v2) -> v1 + v2, 18, 36.5));
		System.out.printf("89 + 2.9 = %f%n", calculate((double v1, double v2) -> v1 / v2, 89, 2.9));
		System.out.printf("-36.5 = %f%n", calculate((double v) -> -v, 36.5));
		System.out.printf("12 + 12 = %f%n", calculate((double v1, double v2) -> v1 * v2, 12, 12));

	}

	private static Object calculate(UnaryCalculator calc, double v) {
		// TODO Auto-generated method stub
		return calc.calculator(v);
	}

	private static Object calculate(BinaryCalculator calc, double v1, double v2) {
		// TODO Auto-generated method stub
		return calc.calculator(v1, v2);
	}
}
 