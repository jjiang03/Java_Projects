package textExcel;

public class TextCell implements Cell
{
	private String cText;
	
	public TextCell(String text)
	{
		cText = text;
	}
	

	@Override
	public String abbreviatedCellText() 
	{
		// TODO Auto-generated method stub
		String String = cText;
		String = cText.substring(0, cText.length() - 1);
		String += "          ";
		String = String.substring(1,11);
		return String;
	
		
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return cText;
	}
	
}
