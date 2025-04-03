/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libraryloan;

import java.util.ArrayList;

/**
 *
 * @author yuanb
 */
public class Library {
     private ArrayList<Book> books;  // List to store books

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Loan a book
    public void loanBook(Book book, int loanCount) {
        if (books.contains(book)) {
            book.decrementCopies(loanCount);
        } else {
            System.out.println("Book not found in library.");
        }
    }

    // Display all books in the library
    public void displayLibrary() {
        System.out.println("\nLibrary Inventory:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
