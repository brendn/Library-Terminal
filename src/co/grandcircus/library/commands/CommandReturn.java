package co.grandcircus.library.commands;

import co.grandcircus.library.*;

public class CommandReturn extends Command {

    public CommandReturn() {
        super("return", "Returns the specified book.  Usage: return <index>");
    }

    @Override
    public void execute(String input) {
        int index = parse(input);
        try {
            LibraryItem book = Library.INVENTORY.getItems().get(index);
            if (book != null) {
                if (book.getStatus() != Status.ON_SHELF) {
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
