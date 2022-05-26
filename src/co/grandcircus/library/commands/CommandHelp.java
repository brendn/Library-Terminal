package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("help");
    }

    @Override
    public void execute(String input) {
        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d books. To see what we have, type 'list'!%n", Library.INVENTORY.getMainBookList().size());
        System.out.println("To search for a book, type 'search <author>' or 'search <title>>'..");
        StringBuilder out = new StringBuilder();
        Library.COMMANDS.stream().forEach(command -> {
            out.append(String.format("%s%t%s%n", getName(), getHelp()));
        });
        System.out.println(out);
    }
}
