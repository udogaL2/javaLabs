package lib;

import model.*;

import java.util.Scanner;
import java.util.ArrayList;

import static lib.Lang.print;
import static lib.Parser.getUserStringWhileIsNotValid;

import static lib.action.CinemaAdminAction.*;
import static lib.action.CinemaHallAdminAction.*;
import static lib.action.FilmAdminAction.*;
import static lib.action.ArmchairAdminAction.*;

public class Application
{
	private final ArrayList<Cinema> cinemaList;
	private final ArrayList<Armchair> armchairTemplateList;
	private final ArrayList<FilmSession> filmSessionList;
	private final ArrayList<Film> filmList;

	public static Lang lang;
	public static Scanner inScanner;
	private boolean running;
	public static boolean isAdmin;

	public Application()
	{
		cinemaList = new ArrayList<>();
		armchairTemplateList = new ArrayList<>();
		filmSessionList = new ArrayList<>();
		filmList = new ArrayList<>();
		running = true;
		isAdmin = false;

		lang = new Lang();
		inScanner = new Scanner(System.in);
	}

	public void start()
	{
		startMessage();

		while (running)
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
						startCinemaAdminAction(cinemaList);
					}

					break;

				case (2):
					if (isAdmin)
					{
						startCinemaHallAdminAction(cinemaList, armchairTemplateList);
					}

					break;

				case (3):
					if(isAdmin)
					{
						startFilmAdminAction(filmList);
					}

					break;

				case (4):
					break;

				case (5):
					if (isAdmin)
					{
						startArmchairAdminAction(armchairTemplateList);
					}
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
				running = false;
				return;
			default:
				print(lang.getMessage("APPLICATION_COMMAND_NOT_FOUND"));
				break;
		}
	}
}
