package co.grandcircus.library;

import java.util.ArrayList;
import java.util.Stack;

public class Inventory {

	private ArrayList<Book> mainBookList = new ArrayList<>();
	private Stack<Book> returns = new Stack<>();

	public ArrayList<Book> getMainBookList() {
		return mainBookList;
	}
	
	public void addBook(Book book) {
		this.mainBookList.add(book);
	}

	public Stack<Book> getReturns() {
		return returns;
	}
}
