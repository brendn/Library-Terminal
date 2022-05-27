package co.grandcircus.library.commands;

import co.grandcircus.library.*;

//TODO: Checkout by name or ensure there's an ID provided
public class CommandCheckOut extends Command {

    public CommandCheckOut() {
        super("checkout", "Checks out the specified book.  Usage: checkout <index>");
    }

    @Override
    public void execute(String input) {
        // Get the index of the item we are trying to check out
        int index = parse(input);

        // Find the book at the specified index
        LibraryItem book = Library.INVENTORY.getItems().get(index);

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
        }
    }
}
