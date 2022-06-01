package co.grandcircus.library.commands;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;
import co.grandcircus.library.Status;

public class CommandGetDueDate extends Command {

	public CommandGetDueDate() {
		super("duedate", "See when an item is due back. Usage: duedate <index>");
	}

	@Override
	public void execute(String input) {
		// Get the index of the item we are trying to check out
        int index = parse(input);

        // Find the item at the specified index
        LibraryItem book = Library.INVENTORY.getItems().get(index);
        
        // Check to see if the item is available to be looked at
        if (book != null && book.getStatus() == Status.CHECKED_OUT) {
        	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        	System.out.println(book.getTitle() + " is due on : " + df.format(book.getDueDate()));
        	
        } else {
        	System.out.println("That item is currently on the shelf!");
        }
		
	}

}
