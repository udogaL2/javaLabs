package view;

import model.Cinema;
import model.CinemaHall;

import java.util.ArrayList;

public class CinemaView
{
	static public void printCinema(Cinema cinema)
	{
		ArrayList<CinemaHall> cinemaHallList =  cinema.getCinemaHallList();
		System.out.println(cinema.getTitle());
		for (CinemaHall cinemaHall : cinemaHallList)
		{
			System.out.println(cinemaHall);
		}
	}
}
