/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpe.pkg121.activity.pkg3;

/**
 *
 * @author yuanb
 */
public class Book {

    private String Title;
    private String author;
    private int copies;

    public Book(String title, String author, int copies) {
        this.Title = title;
        this.author = author;
        this.copies = copies;
    }

    public void displayInfo() {
        System.out.println("Title: " + Title + "Author: " + author + "Copies: " + copies);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
