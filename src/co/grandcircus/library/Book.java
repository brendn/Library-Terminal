package co.grandcircus.library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book {

	private final String title;
	private final String author;
	private Status status;
	private int condition;
	private Date dueDate = null;

	public Book(String title, String author, Status status, int condition) {
		this.title = title;
		this.author = author;
		this.status = status;
		this.condition = condition;
	}

	public Book(String title, String author, Status status) {
		this(title, author, status, 10);
	}

	public enum Status {
		ON_SHELF, CHECKED_OUT;
	}

	public void checkIn() {
		if (condition <= 0) {
			condition = 10;
			System.out.println(this.title + " has been RECYCLED. Condition reset to 10.");
		}
		this.status = Status.ON_SHELF;
		this.dueDate = null;
	}

	public void checkOut() {
		condition--;
		this.status = Status.CHECKED_OUT;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 14);
		setDueDate(calendar.getTime());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(this.title + " is due on: " + df.format(getDueDate()));
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCondition() {
		return condition;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
