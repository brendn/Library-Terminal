package co.grandcircus.library.commands;

import co.grandcircus.library.*;

public class CommandReturn extends Command {

    public CommandReturn() {
        super("return", "Returns the specified item.  Usage: return <index>");
    }

    @Override
    public void execute(String input) {
        int index = parse(input);
        try {
            // Try to find the library item at the specified index
            LibraryItem item = Library.INVENTORY.getItems().get(index);
            if (item != null) {
                // Check if it's not already on the shelf
                if (item.getStatus() != Status.ON_SHELF) {
                    item.checkIn();
                    System.out.printf("Thanks for returning %s!", item.getTitle());
                } else {
                    System.out.println("Sorry, this item is already checked in.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error returning item, please try again.");
        }
    }
}
