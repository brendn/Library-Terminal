package co.grandcircus.library;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents an item that will be in the Library's inventory, such as a book or a DVD
 */
public interface LibraryItem {

    /**
     * Status of the item, aka whether it is on the shelf or checked out.
     */
    Status getStatus();

    /**
     * Title of the item, used to display throughout the program.
     */
    String getTitle();

    /**
     * The author(s) of the item.  For {@link co.grandcircus.library.items.DVD} items this would represent
     * the director(s).
     */
    
    Date getDueDate();

    /**
     * Return the Due Date for a given item.
     */
    ArrayList<String> getAuthor();

    /**
     * Lists the preview elements
     */
    ArrayList<String> getPreview();

    /**
     * Executed every time the item is checked into the library.
     */
    void checkIn();

    /**
     * Executed every time the item is checked out of the library.
     */
    void checkOut();
}
