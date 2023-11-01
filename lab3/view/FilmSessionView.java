package view;

import lib.Parser;
import model.FilmSession;
import view.FilmView;

import java.util.ArrayList;

public class FilmSessionView
{
	public static String prepareFilmSessionToPrint(FilmSession filmSession)
	{
		return FilmView.prepareFilmToPrint(filmSession.getFilm()) + " (" + Parser.parseDateToString(filmSession.getStartTime()) + ")";
	}

	public static String prepareFilmSessionListToPrint(ArrayList<FilmSession> filmSessionList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < filmSessionList.size(); i++)
		{
			FilmSession filmSession = filmSessionList.get(i);
			result.append(i + 1).append(". ").append(prepareFilmSessionToPrint(filmSession)).append("\n");
		}

		return result.toString();
	}

	public static String prepareFilmSessionToPrint(ArrayList<FilmSession> filmSessionList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < filmSessionList.size(); i++)
		{
			FilmSession filmSession = filmSessionList.get(i);
			result.append(i + 1).append(". ").append(prepareFilmSessionToPrint(filmSession)).append("\n");
		}

		return result.toString();
	}
}
