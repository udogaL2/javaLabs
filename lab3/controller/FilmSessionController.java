package controller;

import model.CinemaHall;
import model.Film;
import model.FilmSession;

import java.util.Date;

public class FilmSessionController
{
    public static FilmSession createNewFilmSession(Film film, Date startTime, CinemaHall cinemaHall)
    {
        return new FilmSession(film, startTime, cinemaHall);
    }
}
