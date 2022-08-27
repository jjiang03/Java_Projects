import java.util.*;

public class Guessing 
{

	public static int getRandomNumber(int low, int high)
	{
		// Math.random() returns a decimal in the range [0, 1)
		// Pick a low and high value and test this out.  Can the 
		// computer choose the low and high bounds as its number?
		int rand = (int) (Math.random() * (high - low + 1)) + low;
		return rand;
	}
	
	public static String compareToSecret(int guessedNum, int secretNum)
	{
		String guessIs = "";
		if (guessedNum < secretNum)
			guessIs = "low";
		else
			guessIs = "high";
		return guessIs;
	}
	
	public static boolean inRange(int low, int high, int num)
	{
		if (low <= num && num <= high)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		String name = console.nextLine();
		System.out.println("Hello " + name);
		
		System.out.println("Enter a minimum value: ");
		int min = console.nextInt();
		System.out.println("Enter a maximum value: ");
		int max = console.nextInt();
		
		int secretNumber = getRandomNumber (min, max);
		boolean correct = false;
		
		while (!correct)
		{
			System.out.println("Guess a number: ");
			int guess = console.nextInt();
			
			if(inRange(min, max, guess))
			{
				if(guess == secretNumber)
				{
					System.out.println("Correct!");
					correct = true;
					
				}
				else
				{
					System.out.println(compareToSecret(guess, secretNumber));
				}
			}
			else
			{
				throw new IllegalArgumentException("Guess is out of range.");
				
			}
		}
		
		
	}

}
