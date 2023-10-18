package view;

import model.Armchair;
import model.CinemaHall;

import java.util.ArrayList;

public class CinemaHallView
{
	static public void printCinemaHall(CinemaHall cinemaHall)
	{
		ArrayList<ArrayList<Armchair>> cinemaHallList =  cinemaHall.getSeatsMatrix();
		System.out.println(cinemaHall.getTitle());
		for (ArrayList<Armchair> rowList : cinemaHallList)
		{
			System.out.println(rowList);
		}
	}
}
