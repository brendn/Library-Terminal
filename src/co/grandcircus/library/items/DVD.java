package co.grandcircus.library.items;

import co.grandcircus.library.Status;
import co.grandcircus.library.items.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVD extends Media {
	
	private int runTime;
	private String director;

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

	}

	@Override
	public void checkOut() {

	}

	@Override
	public String toString() {
		return "DVD Title: " + getTitle() + ", Status: " + getStatus() + ", Run Time: " + runTime + ", Director: " + director;
	}

	@Override
	public void preview() {
		try {
		System.out.println("What would you like to preview?");
		printPreview();
		Scanner scnr = new Scanner(System.in);
		int userChoice = scnr.nextInt();
		System.out.println(getPreview().get(userChoice));
		scnr.close();
		} catch (Exception e) {
			System.out.println("Error at DVD class/preview() method. Please try again or call Customer Support if error persists.");
		}
	}
}
