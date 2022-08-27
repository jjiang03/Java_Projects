package textExcel;

public class RealCell implements Cell
{
	private String input = "";

	public RealCell(String input)
	{
		this.input = input;
	}

	public String abbreviatedCellText() 
	{
		//gets the first 10 spaces of value
		double value = getDoubleValue();
		String string = value + "          ";
		return string.substring(0,10);
	}

	@Override
	public String fullCellText()
	{
		return input;
	}

	public double getDoubleValue()
	{
		return Double.parseDouble(input);
	}
}
