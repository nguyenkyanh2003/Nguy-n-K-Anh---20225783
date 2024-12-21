package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.*;

public class Book extends Media {
    private int contentLength;
    private List<String> authors = new ArrayList<>();

    public void addAuthor(String authorName) throws DupplicatedItemException {
        for (String name : this.authors) {
            if (name.equalsIgnoreCase(authorName)) {
                throw new DupplicatedItemException(name + " is already in the list of authors.");
            }
        }
        this.authors.add(authorName);
        System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
    }

    public void removeAuthor(String authorName) throws NonExistingItemException {
        for (String name : this.authors) {
            if (name.equalsIgnoreCase(authorName)) {
                this.authors.remove(name);
                System.out.println(name + " has been removed from the " + this.getTitle() + " list of authors.");
                return;
            }
        }
        throw new NonExistingItemException(authorName + " is not in the list of authors.");
    }

    @Override
    public String getType() {
        return "Book";
    }

    @Override
    public String getDetails() {
        StringBuilder authorsList = new StringBuilder();
        if (!this.authors.isEmpty()) {
            authorsList.append(this.authors.get(0));
            for (int i = 1; i < this.authors.size(); i++) {
                authorsList.append(", ").append(this.authors.get(i));
            }
        }
        return "Product ID: " + this.getID() +
               "\n\tTitle: " + this.getTitle() +
               "\n\tCategory: " + this.getCategory() +
               "\n\tAuthors: " + authorsList +
               "\n\tContent Length: " + this.contentLength + " pages" +
               "\n\tPrice: $" + this.getCost();
    }

    public Book(String title, String category, int contentLength, float cost) {
        super(title, category, cost);
        this.contentLength = contentLength;
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title) {
        super(title);
    }

    public int getContentLength() {
        return contentLength;
    }

}
