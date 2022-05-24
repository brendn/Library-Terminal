package co.grandcircus.library;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Book> mainBookList = new ArrayList<>();

	public ArrayList<Book> getMainBookList() {
		return mainBookList;
	}
	
	public void addBook(Book book) {
		this.mainBookList.add(book);
	}

	public void printBooks() {
		//TODO
	}

	public Book getBookByTitle(String title) {
		return null; //TODO
	}

	public Book getBookByAuthor(String author) {
		return null; //TODO
	}
}
