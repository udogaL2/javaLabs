package model;

import java.util.ArrayList;

public class CinemaHall
{
	private String title;
	private int rowCount;
	private int seatsInRow;
	private Armchair[][] seatsMatrix;
	private ArrayList<FilmSession> filmSessionList;

	public CinemaHall(String title, int rowCount, int seatsInRow)
	{
		this.title = title;
		this.rowCount = rowCount;
		this.seatsInRow = seatsInRow;
		this.seatsMatrix = new Armchair[rowCount][seatsInRow];
		this.filmSessionList = new ArrayList<>();
	}


	public String getTitle()
	{
		return title;
	}

	public int getRowCount()
	{
		return rowCount;
	}

	public int getSeatsInRow()
	{
		return seatsInRow;
	}

	public Armchair[][] getSeatsMatrix()
	{
		return seatsMatrix;
	}

	public void setSeat(int row, int seat, Armchair seatsMatrix)
	{
		this.seatsMatrix[row][seat] = seatsMatrix;
	}

	public ArrayList<FilmSession> getFilmSessionList()
	{
		return filmSessionList;
	}

	public void addFilmSession(FilmSession filmSessionList)
	{
		this.filmSessionList.add(filmSessionList);
	}
}
