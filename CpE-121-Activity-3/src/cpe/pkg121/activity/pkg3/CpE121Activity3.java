package cpe.pkg121.activity.pkg3;

public class CpE121Activity3 {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984 ", "George Orwell ", 5);
        Book book2 = new Book("To Kill a Mockingbird ", "Harper Lee ", 3);
        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Before update: ");
        library.displayLibrary();

        library.updateBookTiltle(book1, "Nineteen Eighty-Four");
        System.out.println("\n After updating book title:");
        library.displayLibrary();

        //task B
        int originalNumber = 123;
        System.out.println("\n Original Number before method call: " + originalNumber);
        library.attempPrimativeChange(originalNumber);
        System.out.println("Original number after method call: " + originalNumber);
    }
}
