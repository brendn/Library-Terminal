package co.grandcircus.library;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import co.grandcircus.library.Book.Status;

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
		Date expected = book.getDueDate();
		Date actual = book.getDueDate();
		assertEquals(expected, actual);
	}
	
	
	
}