package controller;

import model.Armchair;
import model.CinemaHall;

import java.util.ArrayList;

public class CinemaHallController
{
	static public CinemaHall createNewCinemaHall(String title, int rowCount)
	{
		return new CinemaHall(title, rowCount);
	}

	static public void addArmchairToCinemaHall(CinemaHall cinemaHall, int rowIndex, Armchair armchairTemplate, int count)
	{
		addArmchairToListFromTemplate(cinemaHall.getSeatsMatrix().get(rowIndex), armchairTemplate, count);
	}

	static private void addArmchairToListFromTemplate(ArrayList<Armchair> armchairList, Armchair armchairTemplate, int count)
	{
		for (int armchairIndex = 0; armchairIndex < count; armchairIndex++)
		{
			Armchair newArmchair = new Armchair(
				armchairTemplate.getTitle(),
				armchairTemplate.getDescription(),
				armchairTemplate.getType()
			);

			newArmchair.setNumber(armchairList.size() + 1);

			armchairList.add(newArmchair);
		}
	}
}
