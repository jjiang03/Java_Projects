//Justin Jiang
//October 3, 2021
//Describes the features of a quadratic using the Quadratic class and coefficient input from the user
import java.util.Scanner;
public class QuadraticClient 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		double a, b, c;
		String exit = "quit";
		String userInput = "random";
		
		while(!userInput.equals(exit))
		{
			System.out.println("Welcome to the Quadratic Describer");
			System.out.println("Provide values for coefficients a, b, and c");
			System.out.println("");
			
			System.out.print("a: ");
			a = input.nextDouble();
			System.out.print("b: ");
			b = input.nextDouble();
			System.out.print("c: ");
			c = input.nextDouble();
			
			Quadratic.quadrDescriber(a, b, c);
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			userInput = input.next();
			System.out.println("");
		}
	}

}
