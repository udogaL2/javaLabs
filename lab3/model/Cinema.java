package model;

import java.util.ArrayList;

public class Cinema
{
	private String title;
	private ArrayList<CinemaHall> cinemaHallList;

	public Cinema(String title, ArrayList<CinemaHall> cinemaHallList)
	{
		this.title = title;
		this.cinemaHallList = cinemaHallList;
	}

	public String getTitle()
	{
		return title;
	}

	public ArrayList<CinemaHall> getCinemaHallList()
	{
		return cinemaHallList;
	}

	public void addCinemaHall(CinemaHall cinemaHall)
	{
		this.cinemaHallList.add(cinemaHall);
	}
}
