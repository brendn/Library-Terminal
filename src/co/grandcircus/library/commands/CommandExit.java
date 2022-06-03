package co.grandcircus.library.commands;

import co.grandcircus.library.Command;

import java.util.Scanner;

public class CommandExit extends Command {

    public CommandExit() {
        super("exit", "Closes the application");
    }

    @Override
    public void execute(String input, Scanner scanner) {
        scanner.close();
    }
}
