package hust.soict.hedspi.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private LocalDate dateAdded;
    private int id;
    private static int nbMedia = 1;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Simplified equals method
    @Override
    public boolean equals(Object medium) {
        if (this == medium) return true;
        if (medium == null || getClass() != medium.getClass()) return false;
        Media that = (Media) medium;
        return this.title.equalsIgnoreCase(that.getTitle());
    }

    // Search method to check if title contains a given string
    public boolean search(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    // Constructor with title, category, and cost, initializes dateAdded
    public Media(String title, String category, float cost) {
        this(title, category);
        this.cost = cost;
    }

    // Constructor with title and category, initializes dateAdded
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = nbMedia++;
        this.dateAdded = LocalDate.now(); // Default to current date
    }

    // Constructor with only title, initializes category to "Unknown" and dateAdded
    public Media(String title) {
        this(title, "Unknown");
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate date) {
        this.dateAdded = date;
    }

    public abstract String getType();

    public abstract String getDetails();

    @Override
    public String toString() {
        return this.getDetails();
    }
}
