//Justin Jiang
//August 24, 2021
//Creates a Math Library that holds calculation methods
public class Calculate 
{
	//Returns the square of an integer input
	public static int square(int num1) 
	{
		int result = 0;
		result = num1 * num1;
		return result;
	}
	
	//Returns the cube of an integer input
	public static int cube(int num1)
	{
		int result = 0;
		result = num1 * num1 * num1;
		return result;
	}
	
	//Returns the average of two double inputs
	public static double average(double num1, double num2)
	{
		double result = (num1 + num2)/2;
		return result;
	}
	
	//Returns the average of three double inputs
	public static double average(double num1, double num2, double num3)
	{
		double result = (num1 + num2 + num3)/3;
		return result;
	}
	
	//Converts a double input into degrees
	public static double toDegrees(double num1)
	{
		double result = (num1 * 180)/ 3.14159;
		return result;
	}
	
	// Converts a double input into radians
	public static double toRadians(double num1)
	{
		double result = (num1 * 3.14159)/180;
		return result;
	}
	
	//Plugs in three different doubles into the equation b^2 - 4ac
	public static double discriminant(double a, double b, double c)
	{
		double result = (b*b) - (4 * a * c);
		return result;
	}
	
	//Takes three integers and converts it into a mixed number
	public static String toImproperFrac(int num1, int num2, int num3)
	{
		int numerator = (num1 * num3 + num2);
		int denominator = num3;
		String result = numerator + "/" + denominator;
		return result;
	}
	
	//Returns the mixed number of two integers
	public static String toMixedNum(int num1, int num2)
	{
		int wholeNum = num1/num2;
		int denominator = num2;
		int numerator = num1 % num2;
		String result = wholeNum + "_" + numerator + "/" + denominator;
		return result;
	}
	
	//Converts a binomial multiplication of the form (ax +b)(cx +d) into a quadratic equation ax^2 + bx +c
	public static String foil(int a, int b, int c, int d, String var)
	{
		int first = a * c;
		int second = (a * d) + (b * c);
		int third = b * d;
		String result = first + var + "^2" + " + " + second + var + " + " + third;
		return result;
	}
	
	//Determines if a number is divisible by another number
	public static Boolean isDivisibleBy(int num1, int num2)
	{
		if(num2 == 0) throw new IllegalArgumentException("Can't Divide by 0");
		if(num1 % num2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//Returns the absolute value of a number
	public static double absValue(double num1)
	{
		if(num1 < 0)
		{
			return num1 * -1;
		}
		return num1;
	}
	
	//returns the max number out of two numbers
	public static double max(double num1, double num2)
	{
		if (num1 > num2) 
		{
			return num1;
		}
		else
		{
			return num2;
		}
	}
	
	//returns the max number out of three numbers
	public static double max(double num1, double num2, double num3)
	{
		if (num1 >=  num2 && num1 >= num3)
		{
			return num1;
		}
		if (num2 >= num1 && num2 >= num3)
		{
			return num2;
		}
		if (num3 >= num1 && num3 >= num2)
		{
			return num3;
		}
		else
		{
			return num1;
		}
	
	}
	
	//returns the minimum number out of two numbers
	public static int min(int num1, int num2)
	{
		if (num1 < num2)
		{
			return num1;
		}
		else 
		{
			return num2;
		}
	}
	
	//Rounds a double to two decimal places
	public static double round2(double num1)
	{
		if (num1 >= 0)
		{
			num1 = num1 * 100 + 0.5;
			num1 = (int)num1;
			num1 = num1/100;
			return num1;
		}
		else
		{
		num1 = num1 * 100 - 0.5;
		num1 = (int)num1;
		num1 = num1/100;
		return num1;
		}
	}
	
	//Finds the exponent of a number to a positive integer
	public static double exponent(double num1, int num2)
	{
		if(num2 < 0 || num2 == 0 && num1 == 0)throw new IllegalArgumentException("Invalid: Negative Power");
		double num3 = num1;
		for(int i = 1; i < num2; i++)
		{
			num1 *= num3;
		}
		if (num2 == 0) 
		{
			num1 = 1;
		}
		return num1;
	}
	
	//Returns factorial of an integer
	public static int factorial(int num1)
	{
		if(num1 < 0)throw new IllegalArgumentException("Invalid: Negative Number");
		for(int i = (num1-1); i > 0; i--)
		{
			num1*=i;
		}
		return num1;
	}
	
	//Checks to see if input is a prime integer
	public static Boolean isPrime(int num1)
	{
		int num2 = num1 - 1;
		Boolean check = false;
		while(num2 > 1 && check == false)
		{
			check = isDivisibleBy(num1, num2);
			num2--;
		}
		return !check;
	}
	
	//Returns the greatest common factor of two integers
	public static int gcf(int num1, int num2)
	{
		int factor = 1;
			if(num1 == 0 || num2 == 0)
			{
				factor = (int)max(num1, num2);
			}
			else
			{
				for(int i = 2; i <= num1 && i <= num2; i++) 
				{
					if(isDivisibleBy(num1, i) == true && isDivisibleBy(num2, i) == true)
						factor = i;
				}
			}
		return factor;	
	}
	
	//Returns the square root of a double
	public static double sqrt(double num1)
	{
		if(num1 < 0)throw new IllegalArgumentException("Invalid: Negative Number");
		double i = num1/2;
		while(absValue(num1 - (i*i)) >= 0.005)
		{
			double guess = i;
			i = 0.5*(num1/guess + guess);
		}
		return round2(i);
	}
	
	//Returns the roots of a quadratic equation
	public static String quadForm(int a, int b, int c)
	{
		double root1, root2;
		double inner = discriminant(a, b, c);
		String result = "";
		if(inner < 0)
		{
			result = ("no real roots");
		}
		if(inner == 0)
		{
			root1 = (-b - sqrt(inner))/(2 * a);
			result = "" + round2(root1);
		}
		if (inner >0)
		{
			root1 = (-b - sqrt(inner))/(2 * a);
			root2 = (-b + sqrt(inner))/(2 * a);
			
			root1 = round2(root1);
			root2 = round2(root2);
			
			if(root1 > root2)
			{
				result = root2 + " and " + root1;
			}
			else 
			{
				result = root1 + " and " + root2;
			}
		}
		return result;
	}
}
