package model;

import java.util.Date;

public class FilmSession
{
	private int filmIndex;
	private CinemaHall cinemaHall;
	private Date startTime;

	public FilmSession(int filmIndex, CinemaHall cinemaHall, Date startTime)
	{
		this.filmIndex = filmIndex;
		this.cinemaHall = cinemaHall;
		this.startTime = startTime;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public int getFilmIndex()
	{
		return filmIndex;
	}

	public void setFilmIndex(int filmIndex)
	{
		this.filmIndex = filmIndex;
	}

	public CinemaHall getCinemaHallIndex()
	{
		return cinemaHall;
	}

	public void setCinemaHallIndex(CinemaHall cinemaHall)
	{
		this.cinemaHall = cinemaHall;
	}
}
