package co.grandcircus.library;

import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import co.grandcircus.library.items.Media;

import java.util.Formatter;

public abstract class Command {

    private String name;

    private String help;

    /**
     * Creates a command with the provided name and help.
     *
     * @param name  The name of the command, what will be used to execute it
     * @param help  A basic description of the command
     */
    public Command(String name, String help) {
        this.name = name;
        this.help = help;
    }

    /**
     * A brief description of the command, for more complex commands this can also
     * include the proper usage or more additional information.
     */
    public String getHelp() {
        return help;
    }

    /**
     * The name of the command, this is what will be used to execute the command
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the command.
     *
     * @param input The user input.  If the command contains arguments, this will only contain the arguments.
     */
    public abstract void execute(String input);

    /**
     * Attempts to parse an Integer from the given String.
     *
     * @param s The input String
     * @return A parsed Integer if one is found, otherwise it will return -1
     */
    protected int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }

    protected void printTable(boolean titleRow, LibraryItem... items) {
        Formatter fmt = new Formatter();
        fmt.format("%-5s %-40s %-30s %-15s %-15s\n", "ID", "NAME", "AUTHOR/DIRECTOR", "STATUS", "TYPE");

        for (LibraryItem item : items) {
            if (item != null) {
                String type = item instanceof Book ? "Book" : item instanceof DVD ? "DVD" : item instanceof Media ? "Media" : "";
                fmt.format("%-5d %-40s %-30s %-15s %-15s\n", Library.INVENTORY.getItems().indexOf(item), item.getTitle(), item.getAuthor(), item.getStatus(), type);
            }
        }

        System.out.println(fmt);
    }

    protected void printGeneralHelp() {
        System.out.printf("We currently have %d items. To see what we have, type 'list'!%n", Library.INVENTORY.getItems().size());
        System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'..");
        System.out.println("To preview an item, type 'preview <index>'");
    }
}

