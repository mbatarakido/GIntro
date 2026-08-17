package ben;

import java.util.ArrayList;
import java.util.List;

public class SampleCode {
	
	private String name;
	private int empId;
	private int salary;
	
	public SampleCode(int id, String name, int sal) {
		this.empId = id;
		this.name = name;
		this.salary = sal;
	}
	public boolean equals(Object obj) {
		SampleCode emp = (SampleCode) obj;
		boolean status = false;
		if(this.name.equalsIgnoreCase(emp.name) && this.empId == emp.empId 
				&& this.salary == emp.salary) {
			status = true;
		}
		return status;
	}
	public static List<SampleCode> getEmpList(){
		List<SampleCode> emps = new ArrayList<SampleCode>();
		emps.add(new SampleCode(1, "John", 15000));
		emps.add(new SampleCode(2, "Peter", 25000));
		emps.add(new SampleCode(3, "Simon", 5000));
		return emps;
	}
	public static SampleCode getHighestPaidEmpoyee() {	
		return new SampleCode(2, "Peter", 25000);
	}
	public static String getHighestPaidEmpName() {
		
		return "Peter";
	}
	public int hashCode() {
		return this.empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	/*
	public static void main(String[] args) {
		
	}
	public boolean isEvenNumber(int num) {
		boolean result = false;
		if(num % 2 == 0) {
			result = true;
		}
		return result;
	}*/
}
