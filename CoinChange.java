// Program written by Justin Jiang
// Created on July 7, 2021
// Lab 5, Making Decisions
// This program calculates the change in coins (nickels, dimes, and quarters) after buying an item with a price ranging from 25 cents to 100 cents with one dollar.

import java.util.Scanner;
public class MakingDecisions 
{
	public static void main(String[] args) 
	{
	Scanner cents = new Scanner(System.in);
	System.out.println("Enter the price of your item that ranges from"
			+ " 25 cents to 100 cents in increments of 5 cents.");
	
	int price = cents.nextInt();
	
	//validates the user input to see if it meets all the requirements
	if (price > 24 && price < 101 && price % 5 == 0) 
	{
		System.out.println("Your item costs " + price + " cents."
						+ " You paid one dollar.");
	
		//creates a variable to hold the value for the change left over	
		int change = 100 - price;
			System.out.println("Your total change will be "
							+ change + " cents.");
		
		int quarter = change/25;
		change = change % 25;
		
		int dime = change/10;
		change = change % 10;
		
		int nickel = change/5;
		change = change % 5;
		
		System.out.printf("You will receive " + nickel + " nickel(s), "
				+ dime + " dime(s), and " + quarter + " quarter(s).");
	}
	else 
		{
		//prints all the errors for not following instructions
		if (price < 25) 
			System.out.println("Error. Your price "
				+ "is less than 25 cents.");
		if (price > 100)
			System.out.println("Error. Your price "
				+ "is greater than 100 cents.");
		if (price % 5 != 0) 
			System.out.println("Error. Your price "
				+ "is not divisible by 5. ");
		}
	}
}

// Enter the price of your item that ranges from 25 cents to 100 cents in increments of 5 cents.
// 60
// Your item costs 60 cents. You paid one dollar. 
// Your total change will be 40 cents.
// You will receive 1 nickel(s), 1 dime(s), and 1 quarter(s).
