package controller;

import model.CinemaHall;
import model.FilmSession;

import java.util.Date;

public class FilmSessionController
{
    public static FilmSession createNewFilmSession(int filmIndex, Date startTime, CinemaHall cinemaHallIndex)
    {
        return new FilmSession(filmIndex, cinemaHallIndex, startTime);
    }
}
