package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Lists all available commands.");
    }

    @Override
    public void execute(String input) {
        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d books. To see what we have, type 'list'!%n", Library.INVENTORY.getItems().size());
        System.out.println("To search for a book, type 'search <author>' or 'search <title>>'..");
        StringBuilder out = new StringBuilder();
        for (Command command : Library.COMMANDS) {
        	out.append(command.getName() + " - " + command.getHelp() + "\n");
        }
        System.out.println(out);
    }
}
