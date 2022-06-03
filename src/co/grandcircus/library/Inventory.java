package co.grandcircus.library;

import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import co.grandcircus.library.items.Media;

import java.util.ArrayList;
import java.util.Formatter;

public class Inventory {

	private ArrayList<LibraryItem> items = new ArrayList<>();

	public ArrayList<LibraryItem> getItems() {
		return items;
	}
	
	public void addItem(LibraryItem item) {
		this.items.add(item);
	}

	public void printItems() {
		Formatter fmt = new Formatter();
		fmt.format("%10s %40s %40s %40s %40s\n", "ID", "NAME", "AUTHOR/DIRECTOR", "STATUS", "TYPE");
		fmt.format("%40s %40s %40s\n",""," "," ");
		for (int i = 0; i< items.size(); i++){
			LibraryItem item = items.get(i);
			String type = item instanceof Book ? "Book" : item instanceof DVD ? "DVD" : item instanceof Media ? "Media" : "";
			fmt.format("%10d %40s %40s %40s %40s\n", Library.INVENTORY.getItems().indexOf(item), item.getTitle(), item.getAuthors(), item.getStatus(), type);

		}
		System.out.println(fmt);
	}

	public static LibraryItem getItem(String s) {
		int index;
		try {
			index = Integer.parseInt(s);
		} catch (Exception e) {
			index = -1;
		}
		boolean id = index != -1;
		if (id) {
			return Library.INVENTORY.getItems().get(index);
		} else {
			for (LibraryItem item : Library.INVENTORY.getItems()) {
				if (item.getTitle().equalsIgnoreCase(s)) {
					return item;
				}
			}
		}
		return null;
	}

	public static LibraryItem findItem(String input) {
		LibraryItem book = null;
		for (LibraryItem b : Library.INVENTORY.getItems()) {
			if (b.getTitle().equalsIgnoreCase(input)) {
				return b;
			}
		}
		return book;
	}

	public boolean getBookByTitle(String title) {
		for(int i = 0; i< items.size(); i++){
			if(items.get(i).getTitle().equals(title))
			{
				return true;
			}
		}
		return false;
	}

	public LibraryItem[] getBooksByAuthor(String author) {
		LibraryItem[] booksSearchedByAuthor = new LibraryItem[100];
		int index=0;
		for (int i = 0; i< items.size(); i++){
			if(items.get(i).getAuthors().get(0).equals(author)){
				booksSearchedByAuthor[index]= items.get(i);
				index++;
			}
		}

		return booksSearchedByAuthor;
	}
}
