package com.ben.practice;

import java.util.StringTokenizer;
import java.util.regex.*;
import java.io.*;

class Account implements Serializable{
	private static final long serialVersionUID=1L;
	String username="Mbata";
	String password="pass";
	
	private void writeObject(ObjectOutputStream os) throws Exception{
		os.defaultWriteObject();
		String pwd="123"+password;
		os.writeObject(pwd);
	}
	private void readObject(ObjectInputStream is) throws Exception{
		is.defaultReadObject();
		String pwd=(String)is.readObject();
		password=pwd.substring(3);
	}
}

class SampleTest {
	
	public static void main(String[] args) throws Exception{
		Account ac=new Account();
		FileOutputStream fos=new FileOutputStream("abc.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(ac);
		
		FileInputStream fis=new FileInputStream("abc.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Account bc=(Account)ois.readObject();
		
		System.out.println(bc.username+"-----"+bc.password);
	}
}
