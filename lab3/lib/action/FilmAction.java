package lib.action;

import lib.Parser;

import static lib.Application.*;
import static lib.Application.cinemaList;
import static lib.action.FilmAdminAction.printFilmList;
import static lib.action.FilmSessionAdminAction.printFilmSessionListAction;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class FilmAction
{
	public static void startFilmAction()
	{
		print(lang.getMessage("APPLICATION_FILM_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printFilmList();
				return;
			case (2):
				printFilmSessionListAction();
				return;
			case (3):
				printFilmSessionListAction();
				buyTicketAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	private static void buyTicketAction()
	{
		if (filmSessionList.isEmpty())
		{
			return;
		}

		print(lang.getMessage(""));
		int filmSessionIndex = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (filmSessionIndex >= 0 && filmSessionIndex < cinemaList.size())
		{
			cinemaList.remove(filmSessionIndex);
			return;
		}


	}
}
