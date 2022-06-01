package co.grandcircus.library.commands;

import co.grandcircus.library.Command;
import co.grandcircus.library.Library;
import co.grandcircus.library.LibraryItem;
import co.grandcircus.library.Status;
import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import co.grandcircus.library.items.Media;

import java.util.Scanner;

import static co.grandcircus.library.Inventory.getItem;

public class CommandPreview extends Command {

	public CommandPreview() {
		super("preview", "Preview an item before checking it out. Usage: preview <index> OR preview <name>");
	}

	@Override
	public void execute(String input, Scanner scanner) {
		// Find the item at the specified index
		LibraryItem book = getItem(input);

		// Check to see if the item is available to be looked at
		if (book != null) {
			if (book.getStatus() == Status.ON_SHELF) {
				System.out.println("Here's a preview of " + book.getTitle() + ":");

				for (int i = 0; i < book.getPreview().size(); i++) {
					System.out.println(book.getPreview().get(i));
				}

			} else {
				System.out.println("Sorry, that item is currently checked out.");
				System.out.println("Once it has been returned, you'll be able to skim the contents.");
			}
		} else {
			System.out.println("ERROR: Item not found!");
		}

	}
}
