package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    //Initialize scanner method
		Scanner console = new Scanner(System.in);
		//create new spreadsheet to hold input
		Spreadsheet sheet = new Spreadsheet();
		//ask for user input and collects input
		System.out.println("Enter an input: ");
		String userInput = console.nextLine();
		
		//while user does not input "quit" the system will continue to accept input from the user
		while(!userInput.equalsIgnoreCase("quit"))
		{
			System.out.println(sheet.processCommand(userInput));
			System.out.println("Enter an input: ");
			userInput = console.nextLine();
		}
	
			console.close();
	}
}
	
	

