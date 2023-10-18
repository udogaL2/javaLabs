package controller;

import model.*;

import java.util.ArrayList;

public class CinemaController
{
	static public Cinema createNewCinema(String title)
	{
		return new Cinema(title);
	}

	static public void addCinemaToList(ArrayList<Cinema> cinemaList, Cinema cinema)
	{
		cinemaList.add(cinema);
	}

	static public void addCinemaHallToCinema(ArrayList<Cinema> cinemaList, int index, CinemaHall cinemaHall)
	{
		cinemaList.get(index).getCinemaHallList().add(cinemaHall);
	}
}
