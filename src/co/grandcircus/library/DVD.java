package co.grandcircus.library;

import java.util.ArrayList;
import java.util.Scanner;

public class DVD extends Media{
	
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

	public String getDirector() {
		return director;
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
	
	
	//CREATE THE MEDIA ARRAYLIST
	//ArrayList<Media> mediaList = new ArrayList<>();
	//mediaList.add(goonies);
	//mediaList.add(lostBoys);
	//mediaList.add(standByMe);
	//mediaList.add(attackOnTitan);
	//mediaList.add(all of the books as well)...
	
	//CREATE THE PREVIEW ARRAYLISTS FOR EACH DVD
	//ArrayList<String> gooniesPreview = new ArrayList<>();
	//gooniesPreview.add("Front Cover: A bunch of scared-looking kids crowded around a Pirate skull and gold coins!");
	//gooniesPreview.add("Inside Cover: 'Don't say that, ever say that. Goonies never say die.'");
	//gooniesPreview.add("Back Cover: A deliciously dizzy adventure with crowd-pleasing fun!");
	//ArrayList<String> lostBoysPreview = new ArrayList<>();
	//lostBoysPreview.add("Front Cover: A group of tough-looking young-adults staring you menacingly in the eyes.");
	//lostBoysPreview.add("Inside Cover: 'You'll never grow old Michael, and you'll never die. But you must feed!'");
	//lostBoysPreview.add("Back Cover: A hip, comic twist on classic vampire stories");
	//ArrayList<String> standByMePreview = new ArrayList<>();
	//standByMePreview.add("Front Cover: Four young boys painted above a backdrop of open wilderness");
	//standByMePreview.add("Inside Cover: 'I never had any friends later on like the ones I had when I was twelve...'");
	//standByMePreview.add("Back Cover: Absolutely wonderful...a film I may never forget!");
	//ArrayList<String> attackOnTitanPreview = new ArrayList<>();
	//standByMePreview.add("Front Cover: Two people stand at the foot of a massive crystal-laden cavern; a third person is chained to the walls above them.");
	//attackOnTitanPreview.add("Inside Cover: 'This world is merciless, and it's also very beautiful.'");
	//attackOnTitanPreview.add("Back Cover: Lies uphold these walls.");
	
	//CREATE THE DVD OBJECTS
	//DVD goonies = new DVD("The Goonies", ON_SHELF, gooniesPreview, "Richard Donner");
	//DVD lostBoys = new DVD("The Lost Boys", ON_SHELF, lostBoysPreview, "Joel Schumacher" );
	//DVD standByMe = new DVD("Stand By Me", ON_SHELF, standByMePreview, "Rob Reiner");
	//DVD attackOnTitan = new DVD("Attack On Titan: Season 3", ON_SHELF, attackOnTitanPreview, "Masashi Koizuka");


}
