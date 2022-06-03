package co.grandcircus.library;

import co.grandcircus.library.items.Book;
import co.grandcircus.library.items.DVD;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class LibraryIO {

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

    /**
     * Saves all items in the library's inventory to the Items.xml file
     */
    public static void saveAll() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("class");
            doc.appendChild(root);

            for (LibraryItem item : Library.INVENTORY.getItems()) {
                if (item instanceof Book) {
                    // This creates <book> tag
                    Element book = doc.createElement("book");
                    root.appendChild(book);
                    addSharedTags(item, book, doc);

                    // Add the <condition> tag
                    Element condition = doc.createElement("condition");
                    condition.appendChild(doc.createTextNode(String.valueOf(((Book) item).getCondition())));
                    book.appendChild(condition);
                } else if (item instanceof DVD) {
                    // This creates <book> tag
                    Element dvd = doc.createElement("dvd");
                    root.appendChild(dvd);
                    addSharedTags(item, dvd, doc);

                    // Add the <runtime> tag
                    Element runtime = doc.createElement("runtime");
                    runtime.appendChild(doc.createTextNode(String.valueOf(((DVD) item).getRunTime())));
                    dvd.appendChild(runtime);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Make the formatting look pretty, without this, this would all be one line
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            // Output the file
            StreamResult result = new StreamResult(new File("Items.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addSharedTags(LibraryItem item, Element element, Document doc) {
        // Add the name attribute, eg <book name = "title">
        Attr attr = doc.createAttribute("name");
        attr.setValue(item.getTitle());
        element.setAttributeNode(attr);

        // Add each <author> tag
        for (String s : item.getAuthors()) {
            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode(s));
            element.appendChild(author);
        }
        // Add each <preview> tag
        for (String s : item.getPreview()) {
            Element author = doc.createElement("preview");
            author.appendChild(doc.createTextNode(s));
            element.appendChild(author);
        }

        // Add the <status> tag
        Element status = doc.createElement("status");
        status.appendChild(doc.createTextNode(item.getStatus().toString()));
        element.appendChild(status);
    }

    /**
     * Given there is a <book> tag, we will break down each of the child tags and
     * create a {@link co.grandcircus.library.items.Book} object with the provided information.
     *
     * A Book tag typically looks like this:
     * <book name="Title"> - We declare the title of the book here.
     *      <author>Author Name</author> - You can also have multiple author tags but it isn't necessary
     *      <status>ON_SHELF</status> - This will be either ON_SHELF (checked in) or CHECKED_OUT. {@link Status}
     *      <condition>10</condition> - The condition of the book, anywhere from 0-10
     *      <preview>Description of the front cover</preview> - There must be three preview tags for full preview functionality
     *      <preview>Description of the inside of the book</preview>
     *      <preview>Description of the back of the book</preview>
     * </book>
     */
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
                    // Find the author tag
                    Node authorTag = element.getElementsByTagName("author").item(a);
                    // Get the name of the author from the tag
                    String tagText = authorTag.getTextContent();
                    // Add the author to the author ArrayList
                    authors.add(tagText);
                }

                // Add each of the preview tags to the Book's preview ArrayList
                ArrayList<String> preview = new ArrayList<>();
                for (int p = 0; p < element.getElementsByTagName("preview").getLength(); p++) {
                    // Get the tag itself
                    Node previewTag = element.getElementsByTagName("preview").item(p);
                    // Get the text from the tag
                    String tagText = previewTag.getTextContent();
                    // Add the tag text to the ArrayList
                    preview.add(tagText);
                }

                // Get the status of the book
                String statusTag = getTextValue(element, "status");
                Status status = Status.valueOf(statusTag);

                // Get the condition of the book
                int condition = Integer.parseInt(getTextValue(element, "condition"));

                // Add the book to the inventory
                Library.INVENTORY.addItem(new Book(name, authors, status, condition, preview));
            }
        }
    }

    /**
     * Very similar to how the {@link #loadBooks(NodeList)} method works, just for the DVD class.
     */
    private static void loadDVDs(NodeList dvds) {
        // Iterate through each <DVD> tag
        for (int i = 0; i < dvds.getLength(); i++) {
            Node dvd = dvds.item(i);
            if (dvd.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) dvd;

                // Get the name of the DVD
                String name = element.getAttribute("name");

                ArrayList<String> directors = new ArrayList<>();
                // Iterate through each of the directors
                for (int a = 0; a < element.getElementsByTagName("author").getLength(); a++) {
                    // Find the author tag
                    Node authorTag = element.getElementsByTagName("author").item(a);
                    // Get the name of the author from the tag
                    String tagText = authorTag.getTextContent();
                    // Add the author to the author ArrayList
                    directors.add(tagText);
                }

                // Add each of the preview tags to the DVD's preview ArrayList
                ArrayList<String> preview = new ArrayList<>();
                for (int p = 0; p < element.getElementsByTagName("preview").getLength(); p++) {
                    // Get the tag itself
                    Node previewTag = element.getElementsByTagName("preview").item(p);
                    // Get the text from the tag
                    String tagText = previewTag.getTextContent();
                    // Add the tag text to the ArrayList
                    preview.add(tagText);
                }

                // Get the status of the DVD
                String statusTag = getTextValue(element, "status");
                Status status = Status.valueOf(statusTag);

                // Get the condition of the DVD
                int runtime = Integer.parseInt(getTextValue(element, "runtime"));

                // Add the DVD to the inventory
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