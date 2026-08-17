package com.java.ben;
import java.io.*;
import java.nio.file.*;
public class AllCapsDemo {
	public static void main(String[] args) {
		/*if(args.length < 1) {
			System.out.println("You must specify a filename");
			System.exit(-1);
		}*/
		AllCaps caps = new AllCaps("src/com/java/ben/AllCapsDemo.java");
		caps.convert();
	}
}