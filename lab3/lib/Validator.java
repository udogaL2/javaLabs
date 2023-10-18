package lib;

public class Validator
{

	public static boolean isNumeric(String string)
	{
		try
		{
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e)
		{
			return false;
		}
	}

	public static boolean isStringValid(String string)
	{
		if (string.isEmpty() || string.length() > 256)
		{
			return false;
		}

		return true;
	}
}
