package co.grandcircus.library;

import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class LibraryIO {

    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<DVD> dvdList = new ArrayList<>();

    public static void load() {
        try {
            File in = new File("Items.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(in);
            doc.getDocumentElement().normalize();

            NodeList books = doc.getElementsByTagName("book");
            loadBooks(books);

            NodeList dvds = doc.getElementsByTagName("dvd");
            loadDVDs(dvds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveMeTimePlease() {
        for (LibraryItem item : Library.INVENTORY.getItems()) {
            if (item instanceof Book) {
                Book book = (Book) item;
                String title = "<book name=\"" + book.getTitle() +"\">";
                String author = "<author>" + book.getAuthors().get(0) + "</author>";
                String status = "<status>" + book.getStatus() + "</status>";
                String condition = "<condition>" + book.getCondition() + "</condition>";
                System.out.println(title);
                System.out.println(author);
                System.out.println(status);
                System.out.println(condition);
                if (book.getPreview() != null) {
                    for (String s : book.getPreview()) {
                        System.out.println("<preview>" + s + "</preview>");
                    }
                }
                System.out.println("</book>");
            }
            if (item instanceof DVD) {
                DVD dvd = (DVD) item;
                String title = "<dvd name=\"" + dvd.getTitle() +"\">";
                String author = "<author>" + dvd.getAuthors().get(0) + "</author>";
                String status = "<status>" + dvd.getStatus() + "</status>";
                String runtime = "<runtime>" + dvd.getRunTime() + "</runtime>";
                System.out.println(title);
                System.out.println(author);
                System.out.println(status);
                System.out.println(runtime);
                for (String s : dvd.getPreview()) {
                    System.out.println("<preview>" + s + "</preview>");
                }
                System.out.println("</dvd>");
            }
        }
    }

    private static void loadBooks(NodeList books) {
        // Iterate through each <book> tag
        for (int i = 0; i < books.getLength(); i++) {
            Node book = books.item(i);
            if (book.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) book;

                // Get the name of the book
                String name = element.getAttribute("name");

                ArrayList<String> authors = new ArrayList<>();
                // Iterate through each of the authors
                for (int a = 0; a < element.getElementsByTagName("author").getLength(); a++) {
                    Node authorTag = element.getElementsByTagName("author").item(a);
                    String tagText = authorTag.getTextContent();
                    authors.add(tagText);
                }

                ArrayList<String> preview = new ArrayList<>();
                for (int p = 0; p < element.getElementsByTagName("preview").getLength(); p++) {
                    Node previewTag = element.getElementsByTagName("preview").item(p);
                    String tagText = previewTag.getTextContent();
                    preview.add(tagText);
                }

                // Get the status of the book
                String statusTag = getTextValue(element, "status");
                Status status = Status.valueOf(statusTag);

                // Get the condition of the book
                int condition = Integer.parseInt(getTextValue(element, "condition"));

                Library.INVENTORY.addItem(new Book(name, authors, status, condition, preview));
            }
        }
    }

    private static void loadDVDs(NodeList dvds) {
        // Iterate through each <book> tag
        for (int i = 0; i < dvds.getLength(); i++) {
            Node dvd = dvds.item(i);
            if (dvd.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) dvd;

                // Get the name of the dvd
                String name = element.getAttribute("name");

                ArrayList<String> directors = new ArrayList<>();
                // Iterate through each of the authors
                for (int a = 0; a < element.getElementsByTagName("author").getLength(); a++) {
                    Node authorTag = element.getElementsByTagName("author").item(a);
                    String tagText = authorTag.getTextContent();
                    directors.add(tagText);
                }

                ArrayList<String> preview = new ArrayList<>();
                for (int p = 0; p < element.getElementsByTagName("preview").getLength(); p++) {
                    Node previewTag = element.getElementsByTagName("preview").item(p);
                    String tagText = previewTag.getTextContent();
                    preview.add(tagText);
                }

                // Get the status of the book
                String statusTag = getTextValue(element, "status");
                Status status = Status.valueOf(statusTag);

                // Get the condition of the book
                int runtime = Integer.parseInt(getTextValue(element, "runtime"));

                Library.INVENTORY.addItem(new DVD(name, status, preview, runtime, directors.get(0)));
            }
        }
    }

    /**
     * Added this primarily to keep things tidy, the way to obtain text content just seems too messy
     *
     * @param element The target element
     * @param tag The specific tag to get data from
     * @return The data that the specified tag surrounds.
     * For example, given: <foo>bar</foo>
     * If we use getTextValue(element, "foo"), this will return "bar".
     */
    private static String getTextValue(Element element, String tag) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }

}