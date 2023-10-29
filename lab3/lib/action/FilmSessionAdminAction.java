package lib.action;

import lib.Parser;
import model.FilmSession;
import view.CinemaView;

import java.util.ArrayList;

import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

public class FilmSessionAdminAction
{
	public static void startFilmSessionAdminAction(ArrayList<FilmSession> filmSessionList)
	{
		print(lang.getMessage("APPLICATION_ADMIN_FILM_SESSION_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				return;
			case (2):
				return;
			case (3):
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}
}
