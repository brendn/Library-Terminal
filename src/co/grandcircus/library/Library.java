package co.grandcircus.library;

import java.util.*;

import co.grandcircus.library.commands.*;
import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;

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

        ArrayList<String> gooniesPreview = new ArrayList<>();
        gooniesPreview.add("Front Cover: A bunch of scared-looking kids crowded around a Pirate skull and gold coins!");
        gooniesPreview.add("Inside Cover: 'Don't say that, ever say that. Goonies never say die.'");
        gooniesPreview.add("Back Cover: A deliciously dizzy adventure with crowd-pleasing fun!");
        ArrayList<String> lostBoysPreview = new ArrayList<>();
        lostBoysPreview.add("Front Cover: A group of tough-looking young-adults staring you menacingly in the eyes.");
        lostBoysPreview.add("Inside Cover: 'You'll never grow old Michael, and you'll never die. But you must feed!'");
        lostBoysPreview.add("Back Cover: A hip, comic twist on classic vampire stories");

        INVENTORY.addItem(new DVD("The Goonies", Status.ON_SHELF, gooniesPreview, 114, "Richard Donner"));
        INVENTORY.addItem(new DVD("The Lost Boys", Status.ON_SHELF, lostBoysPreview, 97, "Joel Schumacher" ));

        INVENTORY.addItem(new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT));
        INVENTORY.addItem(new Book("The Shining", "Stephen King", Status.ON_SHELF));
        INVENTORY.addItem(new Book("Harry Potter and the Sorcerer's Stone", "Daniel Radcliffe", Status.ON_SHELF, 5));
        INVENTORY.addItem(new Book("Dilla Time", "Dan Charnas", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("To Kill a Mockingbird", "Harper Lee", Status.ON_SHELF, 4));
        INVENTORY.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", Status.ON_SHELF, 4));
        INVENTORY.addItem(new Book("Frankenstein", "Mary Shelley", Status.ON_SHELF, 4));
        INVENTORY.addItem(new Book("Flowers for Algernon", "Daniel Keyes", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Twilight", "Stephenie Meyer", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("The Hunger Games", "Suzanne Collins", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("James and the Giant Peach", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Charlie and the Chocolate Factory", "Roald Dahl", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("The Graveyard Book", "Neil Gaiman", Status.ON_SHELF, 10));
        INVENTORY.addItem(new Book("Coraline", "Neil Gaiman", Status.ON_SHELF, 10));

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d items. To see what we have, type 'list'!%n", INVENTORY.getItems().size());
        System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'..");

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
            //Input has arguments
            //return 3 -> [return, 3]
            if (s.split(" ").length > 1) {
                for (Command command : COMMANDS) {
                    // Take the actual command text out of the input
                    // So 'return 3' -> '3'
                    // That way when we are working in the execute method we won't have to substring that out
                    if (command.getName().equalsIgnoreCase(s.split(" ")[0])) {
                        try {
                            command.execute(s.substring(command.getName().length() + 1));
                        } catch (Exception e) {
                            System.out.println("Error running command. For help, type 'help'!");
                        }
                        return true;
                    }
                }
            } else {
                // No arguments, so we will iterate each command and run it directly
                for (Command command : COMMANDS) {
                    if (command.getName().equalsIgnoreCase(s)) {
                        try {
                            command.execute(s);
                        } catch (Exception e) {
                            System.out.println("Error running command. For help, type 'help'!");
                        }
                        return true;
                    }
                }
            }
        return false;
    }
}
