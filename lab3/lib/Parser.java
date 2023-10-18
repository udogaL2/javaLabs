package lib;

import lib.Validator;
public class Parser
{
    public static int parseRawIndexToInt(String rowIndex)
    {
        if (!Validator.isNumeric(rowIndex))
        {
            return -1;
        }

        return Integer.parseInt(rowIndex);
    }
}
