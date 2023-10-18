package lib;

public class Parser
{
    public static boolean isNumeric(String string)
    {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int parseRawIndexToInt(String rowIndex)
    {
        if (!isNumeric(rowIndex))
        {
            return -1;
        }

        return Integer.parseInt(rowIndex);
    }
}
