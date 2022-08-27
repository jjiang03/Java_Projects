package textExcel;

public class PercentCell extends RealCell
{

	public PercentCell(String input) 
	{
		//gets rid of percent sign
		super(input.substring(0, input.length()-1));
		// TODO Auto-generated constructor stub
	}
	
	
	public String abbreviatedCellText()
	{
		//cuts the decimal point and every number after it out
		String value = getDoubleValue() + "";
		if(value.contains("."))
		{
			value = value.substring(0, value.indexOf("."));
		}
		//adds percent sign in the new value
		value += "%         ";
		return value.substring(0,10);
		
		
	}
	
	public String fullCellText()
	{
		//divides value by 100 to convert to percent
		double value = getDoubleValue();
		value = value/100;
		return value + "";
	}
	
	public double getDoubleValue()
	{
		return super.getDoubleValue();
	}
	
}
