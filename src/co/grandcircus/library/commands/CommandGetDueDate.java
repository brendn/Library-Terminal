package co.grandcircus.library.commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;
import co.grandcircus.library.Status;

import static co.grandcircus.library.Inventory.getItem;

public class CommandGetDueDate extends Command {

	public CommandGetDueDate() {
		super("duedate", "See when an item is due back. Usage: duedate <index>");
	}

	@Override
	public void execute(String input, Scanner scanner) {
        // Find the item at the specified index
        LibraryItem book = getItem(input);

		if (book == null) {
			print("ERROR: Item not found!");
			return;
		}
        
        // Check to see if the item is available to be looked at
        if (book.getStatus() == Status.CHECKED_OUT) {
        	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        	print(book.getTitle() + " is due on : " + df.format(book.getDueDate()));
        } else {
			print("That item is currently on the shelf!");
        }
	}

}
