//Program written by Justin Jiang
//Created on July 13, 2020
//Lab7, Looping
//The code collects student scores from 0 - 100 and finds the average of the scores
import java.util.Scanner;
public class Looping 
{
	public static void main(String[] args) 
	{
		Scanner scores = new Scanner(System.in);
		System.out.println("Enter student scores less than or equal to 100 or"
				+ " enter a number less than 0 to see average: ");
		
		double recentScore = scores.nextInt();
		//creates double variables to store different values
		double numOfScores, highScore, lowScore, totalScore;
		
		//assigns starting values to each variable
		numOfScores = 0.0;
		highScore = 0.0;
		//Sets the lowest score above 100 so that it can be replaced later
		lowScore = 200.0;
		totalScore = 0.0;	
		
		//if the input is less than 0, exit loop
		while (recentScore >= 0.0)
		{
			if (recentScore <= 100.0)
			{
				//Adds the input values together and counts the num of scores
				totalScore += recentScore;
				++numOfScores;
				
				if (recentScore < lowScore)
					lowScore = recentScore;
				
				if (recentScore > highScore)
					highScore = recentScore;
			}
			else
			{
				System.out.println("Error: the score is greater than 100");
				
			}
			//accepts another input and reruns code through the while block
			recentScore = scores.nextInt();
		}
		
		if (numOfScores > 0.0)
		{
			//This code will run after we enter a negative value
			double average = totalScore/numOfScores;
			
			System.out.println("Lowest Score: " + lowScore);
			System.out.println("Highest Score: " + highScore);
			System.out.println("Total Score: " + totalScore);
			System.out.printf("The average score is around %.2f", average);
			System.out.print(" out of the "+numOfScores+ " scores entered.");
					
		}
		else
			System.out.println("No scores entered.");
		
		scores.close();
	}
}
