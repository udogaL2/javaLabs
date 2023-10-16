package model;

import java.util.Date;

public class FilmSession
{
	private Film film;
	private CinemaHall cinemaHall;
	private Date startTime;
	private boolean[][] purchasedSeatList;

	public FilmSession(Film film, Date startTime, CinemaHall cinemaHall)
	{
		this.film = film;
		this.startTime = startTime;
		this.cinemaHall = cinemaHall;

	}

	public Film getFilm()
	{
		return film;
	}

	public void setFilm(Film film)
	{
		this.film = film;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public CinemaHall getCinemaHall()
	{
		return cinemaHall;
	}

	public void setCinemaHall(CinemaHall cinemaHall)
	{
		this.cinemaHall = cinemaHall;
	}

	public boolean[][] getPurchasedSeatList()
	{
		return purchasedSeatList;
	}

	public void setPurchasedSeat(int row, int seat)
	{
		this.purchasedSeatList[row][seat] = true;
	}

	public void setFreeSeat(int row, int seat)
	{
		this.purchasedSeatList[row][seat] = false;
	}
}
