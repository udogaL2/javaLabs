package lib;

public class Validator
{
	public static int isNumeric(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch (NumberFormatException e)
		{
			return -1;
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
