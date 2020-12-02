package de.telran.data;

public class Book {
    private final String title;
    private final String author;
    private final String publishingHouse;
    private final int dateOfIssue;
    private final int pagesQty;
    private int bookQty;
    private int available;

    //Constructor 1
    public Book(String title, String author, String publishingHouse, int dateOfIssue, int pagesQty,
                int bookQty, int available) {
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.dateOfIssue = dateOfIssue;
        this.pagesQty = pagesQty;
        this.bookQty = bookQty;
        this.available = available;
    }

    //Constructor 2
    public Book(String title, String author, String publishingHouse, int dateOfIssue, int pagesQty,
                int bookQty) {
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.dateOfIssue = dateOfIssue;
        this.pagesQty = pagesQty;
        this.bookQty = bookQty;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public int getDateOfIssue() {
        return dateOfIssue;
    }

    public int getPagesQty() {
        return pagesQty;
    }

    public int getBookQty() {
        return bookQty;
    }

    public void setBookQty(int bookQty) {
        this.bookQty = bookQty;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getDateOfIssue() != book.getDateOfIssue()) return false;
        if (getPagesQty() != book.getPagesQty()) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        return getPublishingHouse().equals(book.getPublishingHouse());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getPublishingHouse().hashCode();
        result = 31 * result + getDateOfIssue();
        result = 31 * result + getPagesQty();
        return result;
    }

    @Override
    public String toString() {
        return "\"" + title + "\"" +
                ", " + author +
                ", " + publishingHouse +
                ", " + dateOfIssue +
                ", " + pagesQty + " pages" +
                " | " + getAvailable() + " books";
    }

    public String myToString() {
        return "\"" + title + "\"" +
                ", " + author +
                ", " + publishingHouse +
                ", " + dateOfIssue +
                ", " + pagesQty;
    }
}
