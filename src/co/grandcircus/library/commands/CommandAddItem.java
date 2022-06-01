package co.grandcircus.library.commands;

import co.grandcircus.library.Command;

import java.util.Scanner;

public class CommandAddItem extends Command {

    public CommandAddItem() {
        super("donate", "Donate a book to the library!");
    }

    @Override
    public void execute(String input, Scanner scanner) {
    }
}
