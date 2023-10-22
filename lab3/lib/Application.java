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
						startFilmAdminAction();
					}

					break;

				case (2):
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

	private void startFilmAdminAction()
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
				break;
		}
	}

	private String getUserStringWhileIsNotValid(boolean isNumber)
	{
		while (true)
		{
			print(lang.getMessage("APPLICATION_USER_INPUT"), true);
			String command = inScanner.nextLine();

			if (Validator.isStringValid(command) && (!isNumber || Validator.isNumeric(command)))
			{
				return command;
			}

			print(lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
		}
	}

	private static int getIndexFromConsole()
	{
		return 0;
	}

	private void printCinemaList()
	{
		print(lang.getMessage("APPLICATION_CINEMA_LIST"));
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

		print(lang.getMessage("APPLICATION_GET_CINEMA_INDEX_TO_DELETE"));
		int index = Parser.parseRawStringToInt(getUserStringWhileIsNotValid(true));

		if (index >= 0 && index < cinemaList.size())
		{
			cinemaList.remove(index);
		}

		print(lang.getMessage("APPLICATION_INDEX_IS_NOT_VALID"));
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
