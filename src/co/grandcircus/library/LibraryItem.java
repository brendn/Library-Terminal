package co.grandcircus.library;

import java.util.ArrayList;

public interface LibraryItem {

    Status getStatus();

    String getTitle();

    ArrayList<String> getAuthor();

    void checkIn();

    void checkOut();
}
