package co.grandcircus.library.commands;

import co.grandcircus.library.*;

import java.util.Scanner;

import static co.grandcircus.library.Inventory.getItem;

public class CommandReturn extends Command {

    public CommandReturn() {
        super("return", "Returns the specified item.  Usage: return <index> OR return <name>");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        LibraryItem item = getItem(input);
        if (item != null) {
            // Check if it's not already on the shelf
            if (item.getStatus() != Status.ON_SHELF) {
                item.checkIn();
                printf("Thanks for returning %s!%n", item.getTitle());
            } else {
                print("Sorry, this item is already checked in.");
            }
        } else {
            print("ERROR: Item not found!");
        }
    }
}
