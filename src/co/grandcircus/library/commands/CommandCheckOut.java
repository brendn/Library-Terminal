package co.grandcircus.library.commands;

import co.grandcircus.library.*;

import java.util.Scanner;

import static co.grandcircus.library.Inventory.getItem;

public class CommandCheckOut extends Command {

    public CommandCheckOut() {
        super("checkout", "Checks out the specified book.  Usage: checkout <index> OR checkout <name>");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        LibraryItem book = getItem(input);
        if (book != null) {
            // Check if the book is on shelf.
            if (book.getStatus() == Status.ON_SHELF) {
                // If so, check out the book
                System.out.printf("Successfully checked out %s.%n", book.getTitle());
                book.checkOut();
            } else {
                // Otherwise let the user know it has already been checked out
                System.out.println("Sorry, this book is already checked out.");
            }
        } else {
            System.out.println("ERROR: Item not found!");
        }
    }
}
