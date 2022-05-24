package co.grandcircus.library;

import java.util.Scanner;

import co.grandcircus.library.Book.Status;

public class Library {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        inventory.addBook(new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT));
        inventory.addBook(new Book("The Shining", "Stephen King", Status.ON_SHELF));
        inventory.addBook(new Book("Harry Potter and the Sorcerer's Stone", "Daniel Radcliffe", Status.ON_SHELF, 5));
        inventory.addBook(new Book("Dilla Time", "Dan Charnas", Status.ON_SHELF, 10));
        inventory.addBook(new Book("To Kill a Mockingbird", "Harper Lee", Status.ON_SHELF, 4));
        inventory.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", Status.ON_SHELF, 4));
        inventory.addBook(new Book("Frankenstein", "Mary Shelley", Status.ON_SHELF, 4));
        inventory.addBook(new Book("Flowers for Algernon", "Daniel Keyes", Status.ON_SHELF, 10));
        inventory.addBook(new Book("Twilight", "Stephenie Meyer", Status.ON_SHELF, 10));
        inventory.addBook(new Book("The Hunger Games", "Suzanne Collins", Status.ON_SHELF, 10));
        inventory.addBook(new Book("James and the Giant Peach", "Roald Dahl", Status.ON_SHELF, 10));
        inventory.addBook(new Book("Charlie and the Chocolate Factory", "Roald Dahl", Status.ON_SHELF, 10));
        inventory.addBook(new Book("The Graveyard Book", "Neil Gaiman", Status.ON_SHELF, 10));
        inventory.addBook(new Book("Coraline", "Neil Gaiman", Status.ON_SHELF, 10));

        System.out.println("Welcome to the Grand Circus Library!");
        System.out.printf("We currently have %d books. To see what we have, type \'list\'!%n", inventory.getMainBookList().size());
        System.out.println("To return a book, type \'return\'.");

        String s = scanner.nextLine();

        if (s.equalsIgnoreCase("list")) {
            inventory.printBooks();
            System.out.println("To check out a book, enter the index of the book you would like.");
            boolean moreCheckouts = true;
            while (moreCheckouts) {
                s = scanner.nextLine();
                if (parse(s) != -1) {
                    Book book = inventory.getMainBookList().get(parse(s));
                    if (book.getStatus() != Status.CHECKED_OUT) {
                        book.checkOut();
                    } else {
                        System.out.println("Sorry, book is currently checked out.");
                    }
                    System.out.println("Would you like to check out another book? (y/n)");
                    s = scanner.nextLine();
                    if (s.equalsIgnoreCase("n")) {
                        moreCheckouts = false;
                    }
                }
            }
        } else if (s.equalsIgnoreCase("return")) {
            inventory.printBooks();
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
		System.out.println("Goodbye!");
        scanner.close();
    }

    private static int parse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }
}
