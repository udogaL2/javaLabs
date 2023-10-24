package controller;

import model.FilmSession;

import java.util.Date;

public class FilmSessionController
{
    public static FilmSession createNewFilmSession(int filmIndex, Date startTime, int cinemaHallIndex)
    {
        return new FilmSession(filmIndex, cinemaHallIndex, startTime);
    }
}
