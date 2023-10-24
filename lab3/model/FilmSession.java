package model;

import java.util.Date;

public class FilmSession
{
	private int filmIndex;
	private int cinemaHallIndex;
	private Date startTime;

	public FilmSession(int filmIndex, int cinemaHallIndex, Date startTime)
	{
		this.filmIndex = filmIndex;
		this.cinemaHallIndex = cinemaHallIndex;
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

	public int getCinemaHallIndex()
	{
		return cinemaHallIndex;
	}

	public void setCinemaHallIndex(int cinemaHallIndex)
	{
		this.cinemaHallIndex = cinemaHallIndex;
	}
}
