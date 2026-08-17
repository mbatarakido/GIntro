package com.java.ben;
import java.io.*;
public class DataStreamPrimeReader {
	public static void main(String[] args) {
		try(FileInputStream file = new FileInputStream("src/400primes.dat");
			BufferedInputStream buff = new BufferedInputStream(file);
			DataInputStream data = new DataInputStream(buff)
		){
			try {
				while(true) {
					int in = data.readInt();
					System.out.println(in + " ");
				}
			}catch(EOFException eof) {
				buff.close();
			}
		}catch(IOException e) {
			System.out.println("Error--" + e.getMessage());
		}
	}
}
