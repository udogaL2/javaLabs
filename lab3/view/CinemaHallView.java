package view;

import model.Armchair;
import model.Cinema;
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

	static public String prepareCinemaHallListToPrint(ArrayList<CinemaHall> cinemaHallList)
	{
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < cinemaHallList.size(); i++)
		{
			CinemaHall cinema = cinemaHallList.get(i);
			result.append(i + 1).append(". ").append(cinema.getTitle()).append('\n');
		}

		return result.toString();
	}

	static public String prepareCinemaHallScheme(CinemaHall cinemaHall)
	{
		StringBuilder result = new StringBuilder();

		boolean isNotEmpty = false;

		int row = 0;
		for (ArrayList<Armchair> armchairList: cinemaHall.getSeatsMatrix())
		{
			row += 1;
			result.append(row).append(". ");
			for (Armchair armchair: armchairList)
			{
				result.append(armchair.getNumber()).append(") ").append(armchair.getType()).append(' ');
			}
			isNotEmpty = isNotEmpty || !armchairList.isEmpty();
			result.append('\n');
		}

		if (isNotEmpty)
		{
			return result.toString();
		}
		else
		{
			return "";
		}
	}

	static public String prepareCinemaHallSchemeToUser(CinemaHall cinemaHall)
	{
		StringBuilder result = new StringBuilder();

		boolean isNotEmpty = false;

		int row = 0;
		for (ArrayList<Armchair> armchairList: cinemaHall.getSeatsMatrix())
		{
			row += 1;
			result.append(row).append(". ");
			for (Armchair armchair: armchairList)
			{
				result.append(armchair.getNumber()).append(") ").append(armchair.getType()).append(' ');
			}
			isNotEmpty = isNotEmpty || !armchairList.isEmpty();
			result.append('\n');
		}

		if (isNotEmpty)
		{
			return result.toString();
		}
		else
		{
			return "";
		}
	}
}
