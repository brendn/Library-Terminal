package co.grandcircus.library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import co.grandcircus.library.commands.CommandEmail;
import co.grandcircus.library.commands.CommandRemoveEmail;
import co.grandcircus.library.items.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

	@Test
	void conditionStartsAt10Test() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT);
		int expected = 10;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void conditionIsDepreciatingTest() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT);
		book.checkIn();
		book.checkOut();
		int expected = 9;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void conditionIsDepreciatingTest2() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF);
		book.checkOut();
		book.checkIn();
		int expected = 9;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void conditionIsDepreciatingTest3() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF, 2);
		book.checkOut();
		book.checkIn();
		int expected = 1;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void conditionIsRecyclingTest() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF, 1);
		book.checkOut();
		book.checkIn();
		int expected = 10;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void statusIsCorrectTest() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF, 1);
		book.checkOut();
		Status expected = Status.CHECKED_OUT;
		Status actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	@Test
	void statusIsCorrectTest2() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.CHECKED_OUT, 1);
		book.checkIn();
		Status expected = Status.ON_SHELF;
		Status actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	@Test
	void dueDateTest() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF, 1);
		book.checkOut();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 14);
		DateFormat fmt = new SimpleDateFormat("MM/dd/YYYY");
		String expected = fmt.format(calendar.getTime());
		String actual = fmt.format(book.getDueDate());
		assertEquals(expected, actual);
	}
	
	@Test
	void dueDateIsNullWhenCheckedInTest() {
		Book book = new Book("Hitchiker's Guide To The Galaxy", "Douglas Adams", Status.ON_SHELF, 1);
		Date expected = null;
		Date actual = book.getDueDate();
		assertEquals(expected, actual);
	}
	
	@Test
	void addToMailingListTest() {
		Scanner scnr = new Scanner(System.in);
		CommandEmail commandEmail = new CommandEmail();
		commandEmail.execute("nickr1@gmail.com", scnr);
		int actual = Library.emailList.size();
		int expected = 1;
		assertEquals(expected, actual);
		Library.emailList.remove(0);
	}
	
	@Test
	void addToMailingListTest2() {
		Scanner scnr = new Scanner(System.in);
		CommandEmail commandEmail = new CommandEmail();
		commandEmail.execute("nick@gmail.com", scnr);
		int actual = Library.emailList.size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeFromMailingListTest() {
		Scanner scnr = new Scanner(System.in);
		CommandEmail commandEmail = new CommandEmail();
		commandEmail.execute("nickr@gmail.com", scnr);
		CommandRemoveEmail commandRemoveEmail = new CommandRemoveEmail();
		commandRemoveEmail.execute("nickr@gmail.com", scnr);
		int actual = Library.emailList.size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	@Test
	void removeFromMailingListTest2() {
		Scanner scnr = new Scanner(System.in);
		CommandEmail commandEmail = new CommandEmail();
		commandEmail.execute("nickr234@gmail.com", scnr);
		CommandRemoveEmail commandRemoveEmail = new CommandRemoveEmail();
		commandRemoveEmail.execute("nickr234@gmail.com", scnr);
		int actual = Library.emailList.size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	
	
	
	
}