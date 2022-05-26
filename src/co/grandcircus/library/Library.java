package co.grandcircus.library;

import java.util.*;

import co.grandcircus.library.Book.Status;
import co.grandcircus.library.commands.*;

public class Library {

    public static final Inventory INVENTORY = new Inventory();
    public static final List<Command> COMMANDS = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        COMMANDS.add(new CommandHelp());
        COMMANDS.add(new CommandList());
        COMMANDS.add(new CommandReturn());
        COMMANDS.add(new CommandSearch());
        COMMANDS.add(new CommandCheckOut());

        INVENTORY.addBook(new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT));
        INVENTORY.addBook(new Book("The Shining", "Stephen King", Status.ON_SHELF));
        INVENTORY.addBook(new Book("Harry Potter and the Sorcerer's Stone", "Daniel Radcliffe", Status.ON_SHELF, 5));
        INVENTORY.addBook(new Book("Dilla Time", "Dan Charnas", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("To Kill a Mockingbird", "Harper Lee", Status.ON_SHELF, 4));
        INVENTORY.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", Status.ON_SHELF, 4));
        INVENTORY.addBook(new Book("Frankenstein", "Mary Shelley", Status.ON_SHELF, 4));
        INVENTORY.addBook(new Book("Flowers for Algernon", "Daniel Keyes", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("Twilight", "Stephenie Meyer", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("The Hunger Games", "Suzanne Collins", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("James and the Giant Peach", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("Charlie and the Chocolate Factory", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("The Graveyard Book", "Neil Gaiman", Status.ON_SHELF, 10));
        INVENTORY.addBook(new Book("Coraline", "Neil Gaiman", Status.ON_SHELF, 10));

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d books. To see what we have, type 'list'!%n", INVENTORY.getMainBookList().size());
        System.out.println("To search for a book, type 'search <author>' or 'search <title>'..");

        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (!runCommand(s)) {
                System.out.println("ERROR: Command not found!");
                System.out.println("To view a list of available commands, type 'help'!");
            }
        }
        
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static boolean runCommand(String s) {
        try {
            if (s.split(" ").length > 1) {
                for (Command command : COMMANDS) {
                    if (command.getName().equalsIgnoreCase(s.split(" ")[0])) {
                        command.execute(s.substring(command.getName().length() + 1));
                        return true;
                    }
                }
            } else {
                for (Command command : COMMANDS) {
                    if (command.getName().equalsIgnoreCase(s)) {
                        command.execute(s);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
