package lib;

import static lib.Lang.print;
import static lib.Application.*;

public class Parser
{
    public static int parseRawStringToInt(String rowString)
    {
        return Integer.parseInt(rowString);
    }

    public static String getUserStringWhileIsNotValid(boolean isNumber)
    {
        while (true)
        {
            print(lang.getMessage("APPLICATION_USER_INPUT"), true);
            String command = inScanner.nextLine();

            if (Validator.isStringValid(command) && (!isNumber || Validator.isNumeric(command) >= 0))
            {
                return command;
            }

            print(lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
        }
    }
}
