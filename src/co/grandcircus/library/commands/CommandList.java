package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;

public class CommandList extends Command {

    public CommandList() {
        super("list", "Lists all books.");
    }

    @Override
    public void execute(String input) {
        LibraryItem[] items = new LibraryItem[Library.INVENTORY.getItems().size()];
        printTable(true, Library.INVENTORY.getItems().toArray(items));
        printGeneralHelp();
    }
}
