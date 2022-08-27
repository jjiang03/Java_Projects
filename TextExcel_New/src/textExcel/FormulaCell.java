package textExcel;

public class FormulaCell extends RealCell
{
	private String input = "";
	private Spreadsheet spreadsheet;

	public FormulaCell(String input, Spreadsheet spreadsheet) {
		super(input);
		
		this.input = input;
		this.spreadsheet = spreadsheet;
		
	}
	
	public String fullCellText()
	{
		return input;
	}
	
	public String abbreviatedCellText()
	{
		//gets the double value for up to 10 digits
		return (getDoubleValue() + "          ").substring(0,10);
	}
	
	public double getDoubleValue()
	{
		
		//gets rid of parenthesis
		String noParen = fullCellText().substring(1, fullCellText().length() -1);
		//stores the values into array
		String [] formulaOperands = noParen.split(" ");
		
		
		double total = 0;
		
		//checks if user input SUM or AVG, index 0 is space
		if(formulaOperands[1].toUpperCase().contains("SUM") || formulaOperands[1].toUpperCase().contains("AVG") )
		{
			//runs the method to get SUM or AVG
			total = getSUMorAVG(formulaOperands);
		}
		else
		{
			
			//if input has no SUM or AVG, stores the first number/letter as a double
			total = getValue(formulaOperands[1]);
			for(int i = 2; i < formulaOperands.length; i+=2)
			{
				//checks if the plus sign is in the equation
				if(formulaOperands[i].contains("+"))
				{
					double replacement = total + getValue(formulaOperands[i+1]);
					total = replacement;
				}
			
				//checks if minus sign is in equation
				else if(formulaOperands[i].contains("-"))
				{
					double replacement = total - getValue(formulaOperands[i+1]);
					total = replacement;
				}
			
				//checks if multiply sign is in equation
				else if(formulaOperands[i].contains("*"))
				{
					double replacement = total * getValue(formulaOperands[i+1]);
					total = replacement;
				}
			
				//checks if division sign is in equation
				else if(formulaOperands[i].contains("/"))
				{
					double replacement = total / getValue(formulaOperands[i+1]);
					total = replacement;
				}
			}
		
		}
		return total;
	}
	
	//checks if string input is a double
	public static boolean isNumeric(String str)
	{ 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}

	//returns the value when given the cell's location
	public double getValue(String val)
	{
		double value;
		if(isNumeric(val))
		{
			value = Double.parseDouble(val);
		}
		else
		{
			SpreadsheetLocation loc = new SpreadsheetLocation(val);
			RealCell differentCell = (RealCell)spreadsheet.getCell(loc);
			value = differentCell.getDoubleValue();
			
		}
		return value;
		
	}
	
	//finds average or sum of between two cells
	public double getSUMorAVG(String [] function)
	{
		double count = 0;
		double sum = 0;
		double result = 0;
		//separates the two given cells by splitting the hyphen
		String [] splitFunction = function[2].split("-");
		
		//gets the location of the two cells
		SpreadsheetLocation firstLoc = new SpreadsheetLocation(splitFunction[0]);
		SpreadsheetLocation lastLoc = new SpreadsheetLocation(splitFunction[1]);
		
		
		for(int row = firstLoc.getRow(); row <= lastLoc.getRow(); row++)
		{
			for(int col = firstLoc.getCol(); col <= lastLoc.getCol(); col++)
			{
				//gets the cell at the specific row and col
				RealCell cellNum = (RealCell)spreadsheet.getCell(row, col);
				//converts the value of cell to double and adds it together
				sum += cellNum.getDoubleValue();
				//checks how many cells there are in total being added
				count++;
			}
		}
		
		if(function[1].toUpperCase().equals("SUM"))
		{
			result = sum;
		}
		
		if(function[1].toUpperCase().equals("AVG"))
		{
			//divides the sum by the total number of cells
			result = sum/count;
		}
		return result;
	}


}
