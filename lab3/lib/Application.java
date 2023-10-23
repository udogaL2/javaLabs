package lib;

import model.*;
import view.*;


import java.util.Scanner;
import java.util.ArrayList;

public class Application
{
	private final ArrayList<Cinema> cinemaList;
	private final ArrayList<Armchair> armchairTemplateList;
	private final ArrayList<FilmSession> filmSessionList;
	private final Lang lang;
	private final Scanner inScanner;
	private boolean runnig;
	private boolean isAdmin;

	public Application()
	{
		cinemaList = new ArrayList<>();
		armchairTemplateList = new ArrayList<>();
		filmSessionList = new ArrayList<>();
		runnig = true;
		isAdmin = false;

		lang = new Lang();
		inScanner = new Scanner(System.in);
	}

	public void start()
	{
		startMessage();

		while (runnig)
		{
			if (isAdmin)
			{
				print(lang.getMessage("APPLICATION_ADMIN_COMMAND_LIST"));
			} else
			{
				print(lang.getMessage("APPLICATION_USER_COMMAND_LIST"));
			}

			String command = getUserStringWhileIsNotValid(true);

			switch (Parser.parseRawStringToInt(command))
			{
				case (1):
					if (isAdmin)
					{
						startCinemaAdminAction();
					}

					break;

				case (2):
					if (isAdmin)
					{
						startCinemaHallAdminAction();
					}

					break;

				case (3):
					break;

				case (4):
					break;

				case (5):
					break;

				case (0):
					startMessage();
					break;

				default:
					print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
					break;
			}
		}
	}

	private void startMessage()
	{
		print(lang.getMessage("APPLICATION_TITLE"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				print(lang.getMessage("APPLICATION_LOGIN_AS_USER"));
				isAdmin = false;
				return;
			case (2):
				print(lang.getMessage("APPLICATION_LOGIN_AS_ADMIN"));
				isAdmin = true;
				return;
			case (0):
				runnig = false;
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
				break;
		}
	}

	private void startCinemaAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_CINEMA_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printCinemaList();
				return;
			case (2):
				createNewCinemaAction();
				return;
			case (3):
				printCinemaList();
				deleteCinemaAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	private void startCinemaHallAdminAction()
	{
		print(lang.getMessage("APPLICATION_ADMIN_CINEMAHALL_COMMAND_LIST"));

		String command = getUserStringWhileIsNotValid(true);

		switch (Parser.parseRawStringToInt(command))
		{
			case (1):
				printCinemaHallList();
				return;
			case (2):
				printCinemaHallSchemeAction();
				return;
			case (3):
				createNewCinemaHall();
				return;
			case (4):
				deleteCinemaHallAction();
				return;
			case (0):
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
		}
	}

	private String getUserStringWhileIsNotValid(boolean isNumber)
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

	private void printCinemaList()
	{
		print(lang.getMessage("APPLICATION_CINEMA_LIST"));

		if (cinemaList.isEmpty())
		{
			print(lang.getMessage("APPLICATION_EMPTY_LIST"));
			return;
		}

		print(CinemaView.prepareCinemaListToPrint(cinemaList));
	}

	private void createNewCinemaAction()
	{
		if (!isAdmin)
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMA_TITLE"));
		String title = getUserStringWhileIsNotValid(false);

		cinemaList.add(new Cinema(title));
	}

	private void deleteCinemaAction()
	{
		if (!isAdmin)
		{
			return;
		}

		if (cinemaList.isEmpty())
		{
			return;
		}

		print(lang.getMessage("APPLICATION_GET_CINEMA_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index >= 0 && index < cinemaList.size())
		{
			cinemaList.remove(index);
			return;
		}

		print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
	}

	private ArrayList<CinemaHall> printCinemaHallList()
	{
		if (!isAdmin)
		{
			return new ArrayList<>();
		}

		printCinemaList();

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

	private void createNewCinemaHall()
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

		printCinemaList();

		print(lang.getMessage("APPLICATION_GET_CINEMAHALL_CINEMA_ID_TO_ADD"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true)) - 1;

		if (index < 0 || index >= cinemaList.size())
		{
			print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
			return;
		}

		cinemaList.get(index).addCinemaHall(new CinemaHall(title, rowCount));
	}

	private void printCinemaHallSchemeAction()
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

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallList();

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

	private void deleteCinemaHallAction()
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

		ArrayList<CinemaHall> cinemaHallList = printCinemaHallList();

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
	}

	private static void print(String message)
	{
		System.out.println(message);
	}

	private static void print(String message, boolean isOnSameLine)
	{
		if (isOnSameLine)
		{
			System.out.print(message);
			return;
		}

		System.out.println(message);
	}
}
