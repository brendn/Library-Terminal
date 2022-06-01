package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;

import java.util.Scanner;

public class CommandHelp extends Command {

    public CommandHelp() {
        super("help", "Lists all available commands.");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        System.out.println("Welcome to the Grand Circus Library!");
        System.out.println("Here's a list of commands you can run:");
        StringBuilder out = new StringBuilder();
        Library.COMMANDS.forEach(command -> {
            out.append("\t").append(command.getName()).append(" - ").append(command.getHelp()).append("\n");
        });
        System.out.println(out);
    }
}
