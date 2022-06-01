package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;

import java.util.Scanner;

public class CommandList extends Command {

    public CommandList() {
        super("list", "Lists all books and DVDs.");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        LibraryItem[] items = new LibraryItem[Library.INVENTORY.getItems().size()];
        printTable(true, Library.INVENTORY.getItems().toArray(items));
        printGeneralHelp();
    }
}
