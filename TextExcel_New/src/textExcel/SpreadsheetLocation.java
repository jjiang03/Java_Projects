package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
	private int row;
	private int col;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	//gives cell location of value
       
    	String rNum = cellName.substring(1);
    	row = Integer.parseInt(rNum) - 1;
    	col = (int) cellName.toUpperCase().charAt(0) - 'A';    	
    }
}
