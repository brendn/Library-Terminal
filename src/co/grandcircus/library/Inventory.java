package co.grandcircus.library;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Book> mainBookList;

	public ArrayList<Book> getMainBookList() {
		return mainBookList;
	}
	
	public void addBook(Book book) {
		this.mainBookList.add(book);
	}
	
	
}
