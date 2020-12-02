package de.telran.dao;

import de.telran.data.Book;

import java.util.Calendar;

public class Library {
    public static Book[] books;
    public static int itemsQty;//Общее количество наименований в библиотеке
    public static int booksQty;//Общее количество книг в библиотеке

    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);

    //Создаём свой конструктор
    public Library(int capacity) {
        books = new Book[capacity];
        itemsQty = 0;
        booksQty = 0;
    }

    public static int getItemsQty() {
        return itemsQty;
    }

    public static int getBooksQty() {
        return booksQty;
    }

    public boolean addBook(Book b) {
        if (itemsQty < books.length) {
            books[itemsQty] = b;
            itemsQty++;
            booksQty += b.getBookQty();
            System.out.println("New arrival to the library: " + b);
            return true;
        }
        return false;
    }

    public static void takeBook(Book b) {
        for (int i = 0; i < Library.getItemsQty(); i++) {
            if (books[i].equals(b)) {
                if (books[i].getAvailable() > 0) {
                    System.out.println("One book was taken from the library: " + Library.books[i].myToString());
                    books[i].setAvailable(books[i].getAvailable() - 1);
                    booksQty--;
                } else {
                    System.out.println("Sorry, this book is not available at the moment.");
                }
            } /*else {
                System.out.println("Sorry, there is no such book in the library");
            }*/
        }
    }

    public static void returnBook(Book b) {
        for (int i = 0; i < Library.getItemsQty(); i++) {
            if (books[i].equals(b)) {
                if (books[i].getAvailable() < books[i].getBookQty()) {
                    System.out.println("One book was returned to the library: " + Library.books[i].myToString());
                    books[i].setAvailable(books[i].getAvailable() + 1);
                    booksQty++;
                }
            } /*else {
                System.out.println("Sorry, this is not our book. We're not able to take it.");
            }*/
        }
    }

    public boolean deleteBook(Book b) {
        for (int i = 0; i < itemsQty; i++) {
            if (books[i].equals(b)) {
                books[i] = books[itemsQty - 1];
                itemsQty--;
                booksQty -= b.getBookQty();
                System.out.println("One book was deleted from the library: " + b);
                return true;
            }
        }
        return false;
    }

    public void outPrint() {
        for (int i = 0; i < itemsQty; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        outPrintData();
    }

    public static void outPrintData() {
        System.out.println("___________________________");
        System.out.println("Total items in the library: " + getItemsQty());
        System.out.println("Total books in the library: " + getBooksQty() + "\n");
    }

    public Book findBookByAuthor(String author) {
        boolean flag = false;
        for (int i = 0; i < itemsQty; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                flag = true;
                //System.out.println(books[i]);
                return books[i];
            }
        }
        if (!flag) {
            System.out.println("Book not found!");
        }
        System.out.println();
        return null;
    }

    public void findOldestBook() {
        Book oldestBook = books[0];
        for (int i = 1; i < itemsQty; i++) {
            if (oldestBook.getDateOfIssue() > books[i].getDateOfIssue()) {
                oldestBook = books[i];
            }
        }
        System.out.println("The oldest book is \"" + oldestBook.getTitle() + "\", "
                + oldestBook.getAuthor() + ", " + oldestBook.getDateOfIssue() + " date of issue.");
        System.out.println("This book was published " + (year - oldestBook.getDateOfIssue()) + " ago. \n");
    }
}
