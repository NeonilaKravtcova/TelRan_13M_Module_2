package de.telran.data;

import java.time.LocalDate;
import java.util.Arrays;

public class Film {
        private String title;
        private LocalDate date;//LocalDate date = new LocalDate.of {2020, 4, 29};
        private Genre genre;
        private Cinema[] cinemas;

    public Film(String title, LocalDate date, Genre genre, Cinema[] cinemas) {
        this.title = title;
        this.date = date;
        this.genre = genre;
        this.cinemas = cinemas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Cinema[] getCinemas() {
        return cinemas;
    }

    public void setCinemas(Cinema[] cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (!getTitle().equals(film.getTitle())) return false;
        if (!getDate().equals(film.getDate())) return false;
        if (getGenre() != film.getGenre()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getCinemas(), film.getCinemas());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getGenre().hashCode();
        result = 31 * result + Arrays.hashCode(getCinemas());
        return result;
    }

    @Override
    public String toString() {
        return "Film: " +
                title + "(" + genre
                + "), date" + date +
                ", cinemas=" + Arrays.toString(cinemas);
    }

    public void myToString() {
        System.out.println("--------------------");
        System.out.println("Film: " + title + " (" + genre + ")");
        System.out.println("--------------------");
        System.out.println("is on in the following cinemas: ");
        outPrint();
    }

    public void outPrint (){
        for (Cinema i : cinemas) {
            System.out.println(i);
        }
        System.out.println();
    }
}
