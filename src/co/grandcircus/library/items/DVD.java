package co.grandcircus.library.items;

import co.grandcircus.library.Status;
import co.grandcircus.library.items.Media;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DVD extends Media {
	
	private int runTime;
	private String director;
	private Date dueDate = null;

	public DVD() {
		super();
	}

	public DVD(String title, Status status) {
		super(title, status);
	}
	
	public DVD(String title, Status status, ArrayList<String> preview) {
		super(title, status, preview);
	}
	
	public DVD(String title, Status status, ArrayList<String> preview, int runTime, String director) {
		super(title, status, preview);
		this.runTime = runTime;
		this.director = director;
	}

	public int getRunTime() {
		return runTime;
	}

	@Override
	public ArrayList<String> getAuthor() {
		return new ArrayList<>(List.of(director));
	}

	@Override
	public void checkIn() {
		this.setStatus(Status.ON_SHELF);
	}

	@Override
	public void checkOut() {
		this.setStatus(Status.CHECKED_OUT); 
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 14);
		setDueDate(calendar.getTime());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(this.getTitle() + " is due on: " + df.format(getDueDate()));
	}

	@Override
	public String toString() {
		return "DVD Title: " + getTitle() + ", Status: " + getStatus() + ", Run Time: " + runTime + ", Director: " + director;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}
