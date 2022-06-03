package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryIO;
import co.grandcircus.library.Status;
import co.grandcircus.library.items.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandDonate extends Command {

    public CommandDonate() {
        super("donate", "Donate a book to the library!");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        // Get the book name
        print("Please enter the name of the book you would like to donate:");
        String bookName = scanner.nextLine();

        // Get the authors
        print("Please enter the author(s) of the book (separated by comma):");
        String in = scanner.nextLine();
        // Just in case user separates authors "like,this" and not "like, this"
        String[] authors = in.split(", ").length > 1 ? in.split(", ") : in.split(",");

        // Preview info
        print("Describe the front cover:");
        String previewFront = scanner.nextLine();
        print("Describe the inner cover:");
        String previewInner = scanner.nextLine();
        print("Describe the back of the book:");
        String previewBack = scanner.nextLine();

        // Create the book object and add it to the library inventory
        Book book = new Book(bookName, new ArrayList<>(List.of(authors)), Status.ON_SHELF, 10,
                new ArrayList<>(List.of(previewFront, previewInner, previewBack)));

        Library.INVENTORY.addItem(book);
        LibraryIO.saveAll();
        print("Thank you for your donation!");
    }
}
