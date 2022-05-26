package co.grandcircus.library;

import java.util.ArrayList;
import java.util.Formatter;

public class Inventory {

	private ArrayList<Book> mainBookList = new ArrayList<>();

	public ArrayList<Book> getMainBookList() {
		return mainBookList;
	}
	
	public void addBook(Book book) {
		this.mainBookList.add(book);
	}

	public void printBooks() {
		Formatter fmt = new Formatter();
		fmt.format("%40s %40s %40s\n", "BOOK NAME", "AUTHOR NAME", "STATUS");
		fmt.format("%40s %40s %40s\n",""," "," ");
		for(int i=0;i< mainBookList.size();i++){
			fmt.format("%40s %40s %40s\n", mainBookList.get(i).getTitle(),mainBookList.get(i).getAuthor().get(0),mainBookList
					.get(i).getStatus());

		}
		System.out.println(fmt);
	}

	public boolean getBookByTitle(String title) {
		for(int i=0;i< mainBookList.size();i++){
			if(mainBookList.get(i).getTitle().equals(title))
			{
				return true;
			}
		}
		return false;
	}

	public Book[] getBooksByAuthor(String author) {
		Book[] booksSearchedByAuthor = new Book[100];
		int index=0;
		for(int i=0;i< mainBookList.size();i++){
			if(mainBookList.get(i).getAuthor().get(0).equals(author)){
				booksSearchedByAuthor[index]=mainBookList.get(i);
				index++;
			}
		}

		return booksSearchedByAuthor;
	}
}
