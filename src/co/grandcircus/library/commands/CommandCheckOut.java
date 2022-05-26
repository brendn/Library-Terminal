package co.grandcircus.library.commands;

import co.grandcircus.library.Book;
import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandCheckOut extends Command {

    public CommandCheckOut() {
        super("checkout", "Checks out the specified book.  Usage: checkout <index>");
    }

    @Override
    public void execute(String input) {
        int index = parse(input);
        try {
            Book book = Library.INVENTORY.getMainBookList().get(index);
            if (book != null) {
                if (book.getStatus() != Book.Status.CHECKED_OUT) {
                    System.out.printf("Successfully checked out %s.%n", book.getTitle());
                    book.checkOut();
                } else {
                    System.out.println("Sorry, this book is already checked out.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error returning book, please try again.");
        }
    }
}
