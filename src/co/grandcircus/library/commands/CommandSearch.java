package co.grandcircus.library.commands;

import co.grandcircus.library.*;
import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import co.grandcircus.library.items.Media;

import java.util.Formatter;

import static co.grandcircus.library.Inventory.findItem;

public class CommandSearch extends Command {

    public CommandSearch() {
        super("search", "search <author> OR search <title>");
    }

    @Override
    public void execute(String input) {
        LibraryItem[] authorResults = Library.INVENTORY.getBooksByAuthor(input);
        boolean foundAuthor = authorResults[0] != null;
        Formatter fmt = new Formatter();
        if (foundAuthor) {
            fmt.format("%10s %40s %40s %40s\n", "ID", "NAME", "AUTHOR/DIRECTOR", "STATUS", "TYPE");
            for (LibraryItem item : authorResults) {
                if (item != null) {
                    String type = item instanceof Book ? "Book" : item instanceof DVD ? "DVD" : item instanceof Media ? "Media" : "";
                    fmt.format("%10d %40s %40s %40s %40s\n", Library.INVENTORY.getItems().indexOf(item), item.getTitle(), item.getAuthor(), item.getStatus(), type);
                }
            }
            System.out.println(fmt);
            System.out.println("To check out a book, enter 'checkout <index>'");
            System.out.println("To return a book, enter 'return <index>'");
        } else {
            LibraryItem item = findItem(input);
            if (item != null) {
                String type = item instanceof Book ? "Book" : item instanceof DVD ? "DVD" : item instanceof Media ? "Media" : "";
                fmt.format("%10s %40s %40s %40s %40s\n", "ID", "NAME", "AUTHOR/DIRECTOR", "STATUS", "TYPE");
                fmt.format("%10d %40s %40s %40s %40s\n", Library.INVENTORY.getItems().indexOf(item), item.getTitle(), item.getAuthor(), item.getStatus(), type);
                System.out.println(fmt);
                System.out.println("To check out a book, enter 'checkout <index>'");
                System.out.println("To return a book, enter 'return <index>'");
            } else {
                System.out.println("Sorry, no results found. Type 'list' to see a list of our books.");
            }
        }
    }
}
