package co.grandcircus.library;

import java.util.*;

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
        COMMANDS.add(new CommandPreview());
        COMMANDS.add(new CommandGetDueDate());

        LibraryIO.load();

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d items. To see what we have, type 'list'!%n", INVENTORY.getItems().size());
        System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'..");
        System.out.println("To see a full list of available commands, type 'help'.");

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
