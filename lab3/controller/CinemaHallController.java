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

	static public void addArmchairToCinemaHall(ArrayList<CinemaHall> cinemaHallList, int cinemaHallIndex, int rowIndex, Armchair armchairTemplate)
	{
		addArmchairToListFromTemplate(cinemaHallList.get(cinemaHallIndex).getSeatsMatrix().get(rowIndex), armchairTemplate);
	}

	static private void addArmchairToListFromTemplate(ArrayList<Armchair> armchairList, Armchair armchairTemplate)
	{
		Armchair newArmchair = new Armchair(
				armchairTemplate.getTitle(),
				armchairTemplate.getDescription(),
				armchairTemplate.getType()
		);

		newArmchair.setNumber(armchairList.size());

		armchairList.add(newArmchair);
	}
}
