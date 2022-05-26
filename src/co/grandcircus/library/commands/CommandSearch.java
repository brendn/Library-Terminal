package co.grandcircus.library.commands;

import co.grandcircus.library.Book;
import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

import java.util.Formatter;

public class CommandSearch extends Command {

    public CommandSearch() {
        super("search", "search <author> OR search <title>");
    }

    @Override
    public void execute(String input) {
        Book[] authorResults = Library.INVENTORY.getBooksByAuthor(input);
        boolean foundAuthor = authorResults[0] != null;
        Formatter fmt = new Formatter();
        if (foundAuthor) {
            fmt.format("%10s %40s %40s %40s\n", "ID", "BOOK NAME", "AUTHOR NAME", "STATUS");
            for (Book book : authorResults) {
                if (book != null) {
                    fmt.format("%10d %40s %40s %40s\n", Library.INVENTORY.getMainBookList().indexOf(book), book.getTitle(), book.getAuthor(), book.getStatus());
                }
            }
            System.out.println(fmt);
            System.out.println("To check out a book, enter 'checkout <index>'");
            System.out.println("To return a book, enter 'return <index>'");
        } else {
            Book book = findBook(input);
            if (book != null) {
                fmt.format("%10s %40s %40s %40s\n", "ID", "BOOK NAME", "AUTHOR NAME", "STATUS");
                fmt.format("%10d %40s %40s %40s\n", Library.INVENTORY.getMainBookList().indexOf(book), book.getTitle(), book.getAuthor(), book.getStatus());
                System.out.println(fmt);
                System.out.println("To check out a book, enter 'checkout <index>'");
                System.out.println("To return a book, enter 'return <index>'");
            } else {
                System.out.println("Sorry, no results found. Type 'list' to see a list of our books.");
            }
        }
    }

    private Book findBook(String input) {
        Book book = null;
        for (Book b : Library.INVENTORY.getMainBookList()) {
            if (b.getTitle().equalsIgnoreCase(input)) {
                return b;
            }
        }
        return book;
    }
}
