/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libraryloan;

/**
 *
 * @author yuanb
 */
public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 5);
        Book book2 = new Book("1984", "George Orwell", 3);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("Before Loan:");
        library.displayLibrary();

        library.loanBook(book1, 2);
        library.loanBook(book2, 1);
        library.loanBook(book3, 3);

        System.out.println("\nAfter Loan:");
        library.displayLibrary();
    }
}
