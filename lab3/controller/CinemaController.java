package controller;

import model.*;

public class CinemaController
{
	static public Cinema createNewCinema(String title)
	{
		return new Cinema(title);
	}


}
