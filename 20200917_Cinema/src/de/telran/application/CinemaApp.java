package de.telran.application;

import de.telran.dao.Schedule;
import de.telran.data.Address;
import de.telran.data.Cinema;
import de.telran.data.Film;
import de.telran.data.Genre;

import java.time.LocalDate;

public class CinemaApp {
    public static void main(String[] args) {
        Cinema cinema1 = new Cinema("Star", new Address("Hauptstrasse", 16));
        Cinema cinema2 = new Cinema("Aurora", new Address("Kaiser-Wilhelm-Strasse", 34));
        Address address = new Address("Berlinerstrasse", 10);

        Cinema cinema3 = new Cinema("Barrikada", address);
        Cinema cinema4 = new Cinema("Rodina", new Address("Berlinerplatz", 3));
        Cinema cinema5 = new Cinema("Spartak", new Address("Alexanderplatz", 1));

        cinema1.getAddress().setStreetName("Wasserturmplatz");
        cinema1.getAddress().setHouseNumber(5);

        Cinema[] cinemas = {cinema1, cinema2, cinema3, cinema4, cinema5};
        Cinema[] cinemas1 = {cinema3, cinema4};
        Cinema[] cinemas2 = {cinema2, cinema5};

        Film film1 = new Film("Harry Potter", LocalDate.of(2020, 9, 18), Genre.ADVENTURE, cinemas);
        Film film2 = new Film("Titanic", LocalDate.of(2020, 9, 20), Genre.DRAMA, cinemas);
        Film film3 = new Film("Hail Ceaser", LocalDate.of(2020, 9, 18), Genre.COMEDY, cinemas1);
        Film film4 = new Film("Forsage", LocalDate.of(2020, 9, 21), Genre.ADVENTURE, cinemas1);
        Film film5 = new Film("Bad Boys for Life", LocalDate.of(2020, 9, 21), Genre.DRAMA, cinemas2);

        Film[] films = {film1, film2, film3, film4, film5};

        Schedule schedule = new Schedule(50);
        schedule.addFilm(film1);
        schedule.addFilm(film2);
        schedule.addFilm(film3);
        schedule.addFilm(film4);
        //schedule.outPrint();
        //schedule.outPrintCinemaFilms("Star");

        schedule.displayFilmsByDate(films, LocalDate.of(2020, 9, 20));
        schedule.displayFilmsByDate(films, LocalDate.of(2020, 9, 18));
        schedule.displayFilmsByDate(films, LocalDate.of(2020, 9, 17));

        schedule.displayFilmsByGenre(films, Genre.ADVENTURE);
        schedule.displayFilmsByGenre(films, Genre.DRAMA);
        schedule.displayFilmsByGenre(films, Genre.THRILLER);
    }

}
