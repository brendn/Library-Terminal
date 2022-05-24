package co.grandcircus.library;

import java.util.Scanner;
import java.util.Stack;

import co.grandcircus.library.Book.Status;

public class Library {

	private static Stack<Book> returnStack = new Stack<>();
	
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Scanner scanner = new Scanner(System.in);

		inventory.addBook(new Book("Book", "Author", Status.ON_SHELF, 5));
		inventory.addBook(new Book("Book", "Author", Status.CHECKED_OUT));
		inventory.addBook(new Book("Book", "Author", Status.ON_SHELF, 10));
		inventory.addBook(new Book("Book", "Author", Status.ON_SHELF, 4));

		System.out.println("Welcome to the Grand Circus Library!");
		System.out.printf("We currently have %d books. To see what we have, type \'list\'!%n", inventory.getMainBookList().size());
		System.out.println("To return a book, type \'return\'.");
		
		boolean takeInput = true;
		
		while (takeInput) {
			String s = scanner.nextLine();
			
			if (s.equalsIgnoreCase("list")) {
				//TODO inventory.printBooks();
				System.out.println("To check out a book, enter the index of the book you would like.");
				s = scanner.nextLine();
				if (parse(s) != -1) {
					Book book = inventory.getMainBookList().get(parse(s));
					if (book.getStatus() != Status.CHECKED_OUT) {
						book.checkOut();
					} else {
						System.out.println("Sorry, book is currently checked out.");
					}
				}
			} else if (s.equalsIgnoreCase("return")) {
				//TODO inventory.printBooks();
				boolean moreReturns = true;
				System.out.println("To return a book, enter the index of the book you are returning.");
				while (moreReturns) {
					s = scanner.nextLine();
					if (parse(s) != -1) {
						Book book = inventory.getMainBookList().get(parse(s));
						if (book.getStatus() != Status.ON_SHELF) {
							book.checkIn();
							System.out.printf("Thanks for returning %s!", book.getTitle());
						} else {
							System.out.println("This book is not currently checked out.");
						}
					}
					System.out.println("Would you like to return another book? (y/n)");
					s = scanner.nextLine();
					if (s.equalsIgnoreCase("n")) {
						moreReturns = false;
					}
				}
			}
		}
	}

	private static int parse(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}
}
