package lib.action;

import lib.Parser;
import model.Cinema;
import model.CinemaHall;
import view.CinemaHallView;

import java.util.ArrayList;

import static lib.Application.isAdmin;
import static lib.Application.lang;
import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;
import static lib.action.CinemaAdminAction.printCinemaList;

public class CinemaHallAdminAction
{
	public static void startCinemaHallAdminAction(ArrayList<Cinema> cinemaList)
	{
		print(lang.getMessage("APPLICATION_ADMIN_CINEMAHALL_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printCinemaHallList(cinemaList);
				return;
			case (2):
				printCinemaHallSchemeAction(cinemaList);
				return;
			case (3):
				createNewCinemaHall(cinemaList);
				return;
			case (4):
				deleteCinemaHallAction(cinemaList);
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	private static ArrayList<CinemaHall> printCinemaHallList(ArrayList<Cinema> cinemaList)
	{
		if (!isAdmin)
		{
			return new ArrayList<>();
		}

		printCinemaList(cinemaList);

		if (cinemaList.isEmpty())
		{
			return new ArrayList<>();
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_CINEMA_ID"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return new ArrayList<>();
		}

		print(lang.getMessage("APPLICATION_CINEMAHALL_LIST"));
		ArrayList<CinemaHall> cinemaHallList = cinemaList.get(index).getCinemaHallList();

		if (cinemaHallList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return new ArrayList<>();
		}

		print(CinemaHallView.prepareCinemaHallListToPrint(cinemaList.get(index).getCinemaHallList()));

		return cinemaHallList;
	}

	private static void printCinemaHallSchemeAction(ArrayList<Cinema> cinemaList)
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_GET_CINEMAHALL_EMPTY_CINEMA_LIST"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallList(cinemaList);

		if (cinemaHallList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ID"));

		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		String scheme = CinemaHallView.prepareCinemaHallScheme(cinemaHallList.get(index));
		if (!scheme.isEmpty())
		{
			print(scheme);
			return;
		}

		print(lang.getMessage("APPLICATION_EMPTY_LIST"));
	}


	private static void createNewCinemaHall(ArrayList<Cinema> cinemaList)
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_GET_CINEMAHALL_EMPTY_CINEMA_LIST"));
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ROW_COUNT"));
		int rowCount = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true));

		if (rowCount == 0)
		{
			print(lang.getMessage("APPLICATION_GET_CINEMAHALL_ROW_COUNT_NOT_VALID"));
			return;
		}

		printCinemaList(cinemaList);

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_CINEMA_ID_TO_ADD"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		cinemaList.get(index).addCinemaHall(new CinemaHall(title, rowCount));
	}

	private static void deleteCinemaHallAction(ArrayList<Cinema> cinemaList)
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallList(cinemaList);

		if (cinemaHallList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_INDEX_TO_DELETE"));

		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		cinemaHallList.remove(index);

		//TODO: добавить удаление сеансов в удаляемом кинозале
	}
}