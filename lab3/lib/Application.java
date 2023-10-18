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

	public Application()
	{
		this.cinemaList = new ArrayList<>();
		this.armchairTemplateList = new ArrayList<>();
		this.filmSessionList = new ArrayList<>();
		this.runnig = true;
		this.lang = new Lang();
	}

	public void start()
	{
		Scanner inScanner = new Scanner(System.in);

		while (this.runnig)
		{
			String command = inScanner.nextLine();

			if (!Validator.isStringValid(command))
			{
				print(this.lang.getMessage("APPLICATION_COMMAND_IS_NOT_VALID"));
			}


		}
	}

	private static void print(String message)
	{
		System.out.println(message);
	}
}
