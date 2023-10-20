package lib;

import static lib.Validator.isNumeric;

public class Parser
{
    public static int parseRawIndexToInt(String rowIndex)
    {
        if (!isNumeric(rowIndex))
        {
            return -1;
        }

        return Integer.parseInt(rowIndex);
    }
}
