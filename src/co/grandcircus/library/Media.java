package co.grandcircus.library;

import java.util.ArrayList;

public abstract class Media {
	
	private String title;
	private Status status;
	private ArrayList<String> preview = new ArrayList<>();
	//Stick to 3 items in each ArrayList:
	//0. Actual front cover image description
	//1. Quote from the book/DVD/etc
	//2. Quote from the actual back cover
	
	
	public Media() {
		super();
	}
	
	public Media(String title, Status status) {
		super();
		this.title = title;
		this.status = status;
	}
	
	public Media(String title, Status status, ArrayList<String> preview) {
		super();
		this.title = title;
		this.status = status;
		this.setPreview(preview);
	}

	public enum Status {
		ON_SHELF, CHECKED_OUT;
	}

	public String getTitle() {
		return title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ArrayList<String> getPreview() {
		return preview;
	}
	
	public void setPreview(ArrayList<String> preview) {
		this.preview = preview;
	}
	
	public abstract void preview(); 
	//so a user is able to 'skim' the material before checking out
	//similar to how someone might do this at a real library
	
	
	public void printPreview() {
		for (int i = 0; i < preview.size(); i ++) {
			System.out.println(i + ". " + preview.get(i));
		}
	}

}
