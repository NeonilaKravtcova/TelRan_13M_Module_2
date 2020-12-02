package de.telran.application;

import de.telran.data.Book;
import de.telran.dao.Library;

public class LibraryApp {
    public static void main(String[] args) {
        Book book1= new Book("Harry Potter", "Joan Rollings", "Olympia Press",
                2005, 435, 3, 3);
        Book book2 = new Book("Winnie the Pooh", "Alex Milan", "Pegasus Publishers",
                1957, 256,6, 6);
        Book book3 = new Book("Sherlock Holmes", "Artur Conan Doyle", "Bloomsbury Publishing",
                1892, 388, 1, 1);
        Book book4 = new Book("Little prince", "Saint-Exupery", "Gautier-Languereau",
                1938, 300,5, 5);

        Library myLibrary = new Library(100);
        Library.outPrintData();
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);
        Library.outPrintData();

        myLibrary.outPrint();


        myLibrary.addBook(new Book("War and piece", "Leo Tolstoy", "Bloomsbury Publishing",
                1956, 3000,10, 10));
        myLibrary.outPrint();

        myLibrary.deleteBook(book3);
        myLibrary.outPrint();

        myLibrary.findOldestBook();

        //Book bookToTake = myLibrary.findBookByAuthor("Leo Tolstoy");

        Library.takeBook(myLibrary.findBookByAuthor("Leo Tolstoy"));
        myLibrary.outPrint();

        Library.returnBook(myLibrary.findBookByAuthor("Leo Tolstoy"));
        myLibrary.outPrint();
    }
}
