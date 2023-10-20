package lib;

import model.*;
import controller.*;
import view.*;
import lib.*;


import java.util.Scanner;
import java.util.ArrayList;

public class Application
{
	private ArrayList<Cinema> cinemaList;
	private ArrayList<Armchair> armchairTemplateList;
	private ArrayList<FilmSession> filmSessionList;
	private Lang lang;
	private boolean runnig;
	private boolean isAdmin;

	public Application()
	{
		this.cinemaList = new ArrayList<>();
		this.armchairTemplateList = new ArrayList<>();
		this.filmSessionList = new ArrayList<>();
		this.runnig = true;
		this.isAdmin = false;
		this.lang = new Lang();
	}

	public void start()
	{
		Scanner inScanner = new Scanner(System.in);

		this.startMessage(inScanner);

		while (this.runnig)
		{
			if (this.isAdmin)
			{
				print(this.lang.getMessage("APPLICATION_ADMIN_COMMAND_LIST"));
			}
			else
			{
				print(this.lang.getMessage("APPLICATION_USER_COMMAND_LIST"));
			}

			String command = inScanner.nextLine();

			if (!Validator.isStringValid(command))
			{
				print(this.lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
				continue;
			}

			switch (Parser.parseRawIndexToInt(command))
			{
				case (1):
					if (this.isAdmin)
					{
						this.startFilmAdminAction(inScanner);
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
					startMessage(inScanner);
					break;

				default:
					System.out.println(Parser.parseRawIndexToInt(command));
					print(this.lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
					break;
			}
		}
	}

	private void startMessage(Scanner inScanner)
	{
		print(this.lang.getMessage("APPLICATION_TITLE"));
		String command = "";

		while (true)
		{
			command = inScanner.nextLine();

			if (!Validator.isStringValid(command))
			{
				print(this.lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
				continue;
			}

			switch (Parser.parseRawIndexToInt(command))
			{
				case (1):
					print(this.lang.getMessage("APPLICATION_LOGIN_AS_USER"));
					this.isAdmin = false;
					return;
				case (2):
					print(this.lang.getMessage("APPLICATION_LOGIN_AS_ADMIN"));
					this.isAdmin = true;
					return;
				case (0):
					this.runnig = false;
					return;
				default:
					print(this.lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
					break;
			}
		}
	}

	private void startFilmAdminAction(Scanner inScanner)
	{
		print(this.lang.getMessage("APPLICATION_ADMIN_CINEMA_COMMAND_LIST"));

		String command = "";

		while (!Validator.isStringValid(command))
		{
			command = inScanner.nextLine();

			if (!Validator.isStringValid(command))
			{
				print(this.lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
				return;
			}

			switch (Parser.parseRawIndexToInt(command))
			{
				case (1):
					this.printCinemaList();
					return;
				case (2):
					this.printCinemaList();
					return;
				case (3):
					this.printCinemaList();
					return;
				case (0):
					return;
				default:
					print(this.lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
					break;
			}
		}
	}

	private static int getIndexFromConsole(Scanner inScanner)
	{
		return 0;
	}

	private void printCinemaList()
	{
		print(this.lang.getMessage("APPLICATION_CINEMA_LIST"));
		print(CinemaView.prepareCinemaListToPrint(this.cinemaList));
	}

	private static void print(String message)
	{
		System.out.println(message);
	}
}
