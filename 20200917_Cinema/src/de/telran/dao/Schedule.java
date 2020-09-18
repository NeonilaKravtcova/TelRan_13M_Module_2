package de.telran.dao;

import de.telran.data.Cinema;
import de.telran.data.Film;
import de.telran.data.Genre;

import java.time.LocalDate;

public class Schedule {
    private Film[] films;
    private int size;

    public Schedule(int capacity) {
        films = new Film[capacity];
        size = 0;
    }

    public boolean addFilm(Film film) {
        if (size < films.length) {
            films[size] = film;
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteFilm(Film film) {
        for (int i = 0; i < size; i++) {
            if (films[i].equals(film)) {
                films[i] = films[size - 1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void outPrint() {
        for (int i = 0; i < size; i++) {
            System.out.println(films[i]);
        }
    }

    public void outPrintCinemaFilms(String cinemaName) {
        System.out.println("In cinema " + cinemaName + " you can watch: ");
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (Cinema.cinemaCheck(films[i].getCinemas(), cinemaName)) {
                System.out.println(films[i].getTitle() + " (" + films[i].getGenre() + ") \n" + films[i].getDate());
                System.out.println("-------------------");
                flag = true;
            }
        }
        //Используем тернарный оператор
        System.out.println(flag ? " " : "no information");//или if (!flag) {System.out.println("no information")}
    }

    public void displayFilmsByDate(Film[] films, LocalDate date) {
        System.out.println("--------------------");
        System.out.println(date + " are on: ");
        boolean flag = false;
        for (int i = 0; i < films.length; i++) {
            if (films[i].getDate().compareTo(date) == 0) {
                films[i].myToString();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Movies are not found \n");
        }
    }

    public void displayFilmsByGenre(Film[] films, Genre genre){
        System.out.println("--------------------");
        System.out.println("Movies in genre " + genre + ": ");
        boolean flag = false;
        for (int i = 0; i < films.length; i++) {
            if (films[i].getGenre().equals(genre)) {
                films[i].myToString();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Movies in this genre are not found \n");
        }
    }
}
