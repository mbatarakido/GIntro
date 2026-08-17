package com.ben.me;

import java.util.*;

public class ComicBooks {
	public ComicBooks() {
		
	}
	public static void main(String[] args) {
		//set hashmap
		HashMap<String, Float> quality = new HashMap<>();
		float price1 = 3.00F;
		quality.put("mint", price1);
		float price2 = 2.00F;
		quality.put("near mint", price2);
		float price3 = 1.50F;
		quality.put("very fine", price3);
		float price4 = 1.00F;
		quality.put("fine", price4);
		float price5 = 0.50F;
		quality.put("good", price5);
		float price6 = 0.25F;
		quality.put("poor", price6);
		
		//set the collection
		Comic[] com = new Comic[3];
		com[0] = new Comic("Amazing Spider Man", "1A", "very fine", 12_000.00F);
		com[0].setPrice(quality.get(com[0].condition));
		
		com[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
		com[1].setPrice(quality.get(com[1].condition));
		
		com[2] = new Comic("Thor", "1A", "good", 190.00F);
		com[2].setPrice(quality.get(com[2].condition));
		
		for(int i = 0; i < com.length; i++) {
			System.out.println("Title: "+com[i].title);
			System.out.println("IssueNumber: "+com[i].issueNumber);
			System.out.println("Condition: "+com[i].condition);
			System.out.println("Price: $"+com[i].price+ "\n");
		}
	}	
}
class Comic{
	String title;
	String issueNumber;
	String condition;
	float basePrice;
	float price;
	
	Comic(String title, String issueNumber, String condition, float basePrice){
		this.title = title;
		this.issueNumber = issueNumber;
		this.condition = condition;
		this.basePrice = basePrice;
	}
	void setPrice(float factor) {
		price = basePrice * factor;
	}
}




