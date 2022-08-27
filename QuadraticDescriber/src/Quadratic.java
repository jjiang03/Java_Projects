//Justin Jiang
//October 3, 2021
//Creates a program that describes the features of a quadratic
public class Quadratic 
{
	//Describes the features of a quadratic
	public static void quadrDescriber (double a, double b, double c)
	{
		
		System.out.println(" ");
		System.out.println("Description of the graph of:");
		System.out.println("y = " + a + "x^2 + " + b + "x + " + c);
		
		System.out.println("");
		if (a < 0)
		{
			System.out.println("Opens: Down");
			
		}
		else
		{
			System.out.println("Opens: Up");
		}
		
		System.out.println("Axis of Symmetry: " + axisOfSymmetry(a,b));
		System.out.println("Vertex: " + vertex(a, b, c));
		System.out.println("x-intercepts: " + xIntercepts(a, b, c));
		System.out.println("y-intercepts: " + c);
		System.out.println("");
		
	}
	
	//Returns the axis of symmetry
	public static double axisOfSymmetry (double a, double b)
	{
		double symmetry = -b/(2*a);
		
		return round2(symmetry);
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
		//Returns the vertex coordinates of the quadratic
		public static String vertex(double a, double b, double c)
		{
			String result;
			double xValue = axisOfSymmetry(a,b);
			double yValue = (a * square(xValue)) + (b * xValue) + c;
			result = "(" + xValue + ", " + round2(yValue) + ")";
			return result;
		}
		
		//Returns the square of an integer input
		public static double square(double num1) 
		{
			double result = 0;
			result = num1 * num1;
			return result;
		}
		
		//Returns the x-intercepts of the quadratic
		public static String xIntercepts(double a, double b, double c)
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
					result = root1 + " and " + root2;
				}
				else 
				{
					result = root2 + " and " + root1;
				}
			}
			return result;
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
		
		//Plugs in three different doubles into the equation b^2 - 4ac
		public static double discriminant(double a, double b, double c)
		{
			double result = (b*b) - (4 * a * c);
			return result;
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
		
		
}
