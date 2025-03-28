/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe.pkg121.activity.pkg3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuanb
 */
public class Library {

    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateBookTiltle(Book book, String newTitle) {
        System.out.println("Updating book title form\"" + book.getTitle() + "\" to \"" + newTitle + "\".");
        book.setTitle(newTitle);
    }

    public void attempPrimativeChange(int number) {
        System.out.println("Inside method before change: " + number);
        number = 999;
        System.out.println("Inside method after change: " + number);
    }

    public void displayLibrary() {
        System.out.println("Library Inventory");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
