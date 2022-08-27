//Justin Jiang
//November 12, 2021
//Create a program that prints out the user's username, password, amount of times logged in, total time, and average time
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataAnalysis 
{
	/*
	public static void main(String [] args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String email;
		String getLine = input.nextLine();
		
		
		while(!getLine.equals("end"))
		{
			int timeOfSession = 0;
			email = getLine;
		
			String sessionNumber = input.nextLine();
			int sessionCount = Integer.parseInt(sessionNumber);
			
			for(int i =1; i <= sessionCount; i++)
			{
				String time = input.nextLine();
				timeOfSession = Integer.parseInt(time) + timeOfSession;
			}
			
			double averageTime = (double) timeOfSession / sessionCount;
			String getPass = input.nextLine();
			String pass = getPass.substring(4);
			
			System.out.println(email);
			System.out.println("Password: " + pass);
			System.out.println("Logged in " + sessionCount + " times");
			System.out.println("Total time spent: " + timeOfSession);
			System.out.println("Average session length: " + averageTime);
			System.out.println(" ");
			getLine = input.nextLine();
			
		}
		input.close();	
	}
	*/
	public static void main(String [] args) throws FileNotFoundException
	{
		File file = new File("dataLog.txt");
		Scanner input = new Scanner(file);
		String email;
		String getLine = input.nextLine();
		
		
		
		while(!getLine.equals("end"))
		{
			int timeOfSession = 0;
			email = getLine;
		
			String sessionNumber = input.nextLine();
			int sessionCount = Integer.parseInt(sessionNumber);
			int [] count = new int[sessionCount];
			
			for(int i =1; i <= sessionCount; i++)
			{
				String time = input.nextLine();
				timeOfSession = Integer.parseInt(time) + timeOfSession;
				count[i-1] = Integer.parseInt(time);
			}
			
			
			String getPass = input.nextLine();
			String pass = getPass.substring(4);
			
			System.out.println(emailToUsername(email));
			System.out.println("Password: " + pass);
			System.out.println("Logged in " + sessionCount + " times");
			System.out.println("Total time spent: " + timeOfSession);
			System.out.println("Average session length: " + average(count));
		
		
			System.out.println(" ");
			getLine = input.nextLine();
		
			
		}
		input.close();	
	}
	
	public static double average(int[] arr)
	{
		double totalTime = 0;
		double averageTime;
		for(int i = 0; i < arr.length; i++)
		{
			totalTime += arr[i];
		}
		averageTime = totalTime/arr.length;
		return averageTime;
	}
	
	public static String emailToUsername(String email)
	{
		/*
		 * 22dirksenj79@stu.smuhsd.org
		 */
		String [] name = email.split("@stu.smuhsd.org");
		String wholeName = name[0];
		wholeName = wholeName.substring(2,wholeName.length() - 2);
		char firstLetter = wholeName.charAt(wholeName.length() - 1);
		
		String finalName = firstLetter + wholeName.substring(0, wholeName.length()-1);
		return finalName;
	}

}
