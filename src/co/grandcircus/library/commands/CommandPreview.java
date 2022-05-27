package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;
import co.grandcircus.library.Status;

public class CommandPreview extends Command {

	public CommandPreview() {
		super("preview", "Skim the material to see if it looks interesting before checking it out.");
	}

	@Override
	public void execute(String input) {
		// Get the index of the item we are trying to check out
        int index = parse(input);

        // Find the item at the specified index
        LibraryItem book = Library.INVENTORY.getItems().get(index);
        
        if (book != null && book.getStatus() == Status.ON_SHELF) {
        	System.out.println("Here's a preview of the material:");
   
        	
        } else {
        	System.out.println("Sorry, that item is currently checked out.");
        	System.out.println("Once it has been returned, you'll be able to skim the contents.");
        }
		
	}

}
