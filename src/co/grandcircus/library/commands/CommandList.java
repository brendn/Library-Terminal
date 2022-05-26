package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandList extends Command {

    public CommandList() {
        super("list", "Lists all books.");
    }

    @Override
    public void execute(String input) {
        Library.INVENTORY.printBooks();
        System.out.println("To check out a book, enter 'checkout <index>'");
        System.out.println("To return a book, enter 'return <index>'");
    }
}
