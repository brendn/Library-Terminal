package co.grandcircus.library.commands;

import co.grandcircus.library.*;

import java.util.Scanner;

import static co.grandcircus.library.Inventory.findItem;

public class CommandSearch extends Command {

    public CommandSearch() {
        super("search", "search <author/director> OR search <title>");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        LibraryItem[] authorResults = Library.INVENTORY.getBooksByAuthor(input);
        boolean foundAuthor = authorResults[0] != null;
        if (foundAuthor) {
            printTable(authorResults);
            printGeneralHelp();
        } else {
            LibraryItem item = findItem(input);
            if (item != null) {
                printTable(item);
                printGeneralHelp();
            } else {
                System.out.println("Sorry, no results found. Type 'list' to see a list of our items.");
            }
        }
    }
}
