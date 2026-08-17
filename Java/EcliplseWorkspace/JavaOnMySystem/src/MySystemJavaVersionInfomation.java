
public class MySystemJavaVersionInfomation {
	public static void main(String[] args) {
		System.out.println("Java Version: "+System.getProperty("java.version"));
	    System.out.println("Java Runtime Version: "+System.getProperty("java.runtime.version"));
	    System.out.println("Java Home: "+System.getProperty("java.home"));
	    System.out.println("Java Vendor: "+System.getProperty("java.vendor"));
	    System.out.println("Java Vendor URL: "+System.getProperty("java.vendor.url"));
	    System.out.println("Java Class Path: "+System.getProperty("java.class.path"));
		System.out.println(System.getenv("PATH"));
		System.out.println(System.getenv("TEMP"));
		System.out.println(System.getenv("USERNAME"));
		System.out.println(System.getSecurityManager());
		System.out.println(System.getenv());
		System.out.println(System.getProperties());


	}
}
