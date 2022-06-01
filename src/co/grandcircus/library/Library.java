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
        COMMANDS.add(new CommandAddItem());
        COMMANDS.add(new CommandBlackJack());

        LibraryIO.load();

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d items. To see what we have, type 'list'!%n", INVENTORY.getItems().size());
        System.out.println("To search for an item, type 'search <author/director>' or 'search <title>'..");
        System.out.println("To see a full list of available commands, type 'help'.");

        String s;
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (getCommand(s) != null) {
                Command command = getCommand(s);
                String in = s.split(" ").length > 1 ? s.substring(command.getName().length() + 1) : s;
                command.execute(in, scanner);
            } else {
                System.out.println("ERROR: Command not found!");
                System.out.println("To view a list of available commands, type 'help'!");
            }
        }
        
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static Command getCommand(String in) {
        if (in.split(" ").length > 1) {
            String commandName = in.split(" ")[0];
            for (Command command : COMMANDS) {
                if (command.getName().equalsIgnoreCase(commandName)) {
                    return command;
                }
            }
        } else {
            for (Command command : COMMANDS) {
                if (command.getName().equalsIgnoreCase(in)) {
                    return command;
                }
            }
        }
        return null;
    }

}
