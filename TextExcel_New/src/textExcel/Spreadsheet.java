package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] Arr;
	public Spreadsheet()
	{
		//creates cell with 20 rows and 12 columns
		Cell[][] array = new Cell[20][12];
		Arr = array;
		
		for(int i = 0; i < getRows(); i++)
		{
			for(int n = 0; n < getCols(); n++)
			{
				Arr[i][n] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
	
			if(command.equals(""))
			{
				return "";
			}
		// checks if the input has an equal sign
			if(command.contains(" = "))
			{
				
				//gets rid of the equal sign and splits the location of cell and value assigned into array
				String [] splitCommand = command.split(" = ", 2);
				//uses the first index of array as a location for the row and column location
				SpreadsheetLocation loc = new SpreadsheetLocation(splitCommand[0]);
				//assigns the value to the given location (0 index in the array)
				cellAssignment(splitCommand[1],loc);

				//if the input has quotes, then it will be stores as a text cell
				if(splitCommand[1].startsWith("\""))
				{
					
					Arr[loc.getRow()][loc.getCol()] = new TextCell(splitCommand[1]);
				}
				
			}
			
			//when input is "clear", deletes the values stored in all cells
			else if(command.toLowerCase().contains("clear"))
			{
				//ignores the casing of "clear"
				if(command.equalsIgnoreCase("CLEAR") )
				{
					clearAllCells();
					
				}
				
				//if input contains a space, stores the value after the space as the location
				else
				{
					//deletes value in the stored location cell
					String [] splitCommand = command.split(" ", 2);
					SpreadsheetLocation loc = new SpreadsheetLocation(splitCommand[1]);
					Arr[loc.getRow()][loc.getCol()] = new EmptyCell();
				
				}
				
			}
				
				
			//if input does not contain equal sign, returns the input location's value, ex) if input is A1, then it will return the cell text of A1
			else if(command.length() <= 3)
			{
				SpreadsheetLocation loc = new SpreadsheetLocation(command);
				return Arr[loc.getRow()][loc.getCol()].fullCellText();
			}
		
				//prints grid
				return getGridText();
			

		
	}
	
	public void cellAssignment(String command, SpreadsheetLocation loc)
	{
		//if input has quotes, store input as a text cell
		if(command.contains("\""))
		{
			String newValue = command.substring(command.indexOf("\""));
			Arr[loc.getRow()][loc.getCol()] = new TextCell(newValue);
		}
		
		//if input has a percent sign, store input as percent cell
		else if(command.endsWith("%"))
		{
			Arr[loc.getRow()][loc.getCol()] = new PercentCell(command);
		}
		
		//if input has parenthesis, store value as formula cell
		else if(command.startsWith("("))
		{
			//add "this" in the parameters
			Arr[loc.getRow()][loc.getCol()] = new FormulaCell(command, this);
		}
		
		//if input only contains numbers, store as value cell
		else
		{
			Arr[loc.getRow()][loc.getCol()] = new ValueCell(command);
		}
	}
	
	//method: replaces cell with an empty cell
	public void clearAllCells()
	{
		for(int i = 0; i< getRows(); i++)
		{
			for(int n = 0; n < getCols(); n++)
			{
				Arr[i][n] = new EmptyCell();
			}
		}
	}

	@Override
	//returns a row of 20
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	// returns a column of 12
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	//returns the value of the cell in a specific row and column
	public Cell getCell(int row, int col)
	{
		// TODO Auto-generated method stub
		return Arr[row][col];
	}

	//returns the value of the cell in a specific row and column
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return Arr[loc.getRow()][loc.getCol()];
	}

	//creates a grid to display input
	@Override
	public String getGridText()
	{
		//creates spacing in the beginning to fit numbers later on in the left side
		String entireGrid = "   |";
		
		//adds letters from A to L to the top row
		for(char numLetter = 'A'; numLetter <= 'L'; numLetter++)
		{
			//adds a 9 spaces and a line after each letter
			entireGrid += numLetter + "         |";
		}
		
		//goes to new line
		entireGrid += "\n";
		
		//adds numbers to the first column
		for(int n = 1; n <= getRows(); n++)
		{
			entireGrid += n;
			//if numbers have two digits, add 1 space after number
			if(n > 9)
			{
				entireGrid += " |";
			}
			//if numbers have one digit, add 2 space after number
			else
			{
				entireGrid += "  |";
				
			}
			
			//adds lines to the rest of the row and closes off the last column with a line
			for(int k = 0; k < getCols(); k++)
			{
				entireGrid += Arr[n-1][k].abbreviatedCellText() + "|";
			}
			//goes to new line
			entireGrid += "\n";
		}
		//prints grid
		return entireGrid;
	}

}
