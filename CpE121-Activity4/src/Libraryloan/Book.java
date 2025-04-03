/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libraryloan;

/**
 *
 * @author yuanb
 */
public class Book {
    private String title;
    private String author;
    private int copies;

    // Constructor
    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    // Display book information
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Copies Available: " + copies);
    }

    // Reduce the number of available copies
    public boolean decrementCopies(int count) {
        if (copies >= count) {
            copies -= count;
            System.out.println(count + " copy/copies of \"" + title + "\" loaned successfully.");
            return true;
        } else {
            System.out.println("Not enough copies available for \"" + title + "\".");
            return false;
        }
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getCopies() {
        return copies;
    }
}
