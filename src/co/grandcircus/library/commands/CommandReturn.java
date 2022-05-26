package co.grandcircus.library.commands;

import co.grandcircus.library.Book;
import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandReturn extends Command {

    public CommandReturn() {
        super("return", "Returns the specified book.  Usage: return <index>");
    }

    @Override
    public void execute(String input) {
        int index = parse(input);
        try {
            Book book = Library.INVENTORY.getMainBookList().get(index);
            if (book != null) {
                if (book.getStatus() != Book.Status.ON_SHELF) {
                    book.checkIn();
                } else {
                    System.out.println("Sorry, this book is already checked in.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error returning book, please try again.");
        }
    }
}
