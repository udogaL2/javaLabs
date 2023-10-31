package controller;

import static controller.CinemaHallController.createNewCinemaHall;

import model.CinemaHall;
import model.Film;
import model.FilmSession;

import java.util.Date;

public class FilmSessionController
{
	public static FilmSession createNewFilmSession(Film film, Date startTime, CinemaHall cinemaHall)
	{
		CinemaHall cinemaHallCopy = createNewCinemaHall(cinemaHall.getTitle(), cinemaHall.getRowCount());

		cinemaHallCopy.setSeatsMatrix(cinemaHall.getSeatsMatrix());
		cinemaHallCopy.setFilmSessionList(cinemaHall.getFilmSessionList());

		return new FilmSession(film, cinemaHallCopy, startTime);
	}
}
