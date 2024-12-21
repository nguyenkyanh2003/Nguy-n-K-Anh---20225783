package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media medium) throws CartFullException {
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new CartFullException("The cart is full.");
        } else {
            this.itemsOrdered.add(medium);
            System.out.println(medium.getTitle() + " has been added to the cart.");
        }
    }

    public void removeMedia(Media medium) throws NonExistingItemException {
        if (this.itemsOrdered.remove(medium)) {
            System.out.println(medium.getTitle() + " has been removed from the cart.");
        } else {
            throw new NonExistingItemException(medium.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float cost = 0.0f;
        for (Media medium : itemsOrdered) {
            cost += medium.getCost();
        }
        return Math.round(cost * 100.0f) / 100.0f;
    }

    public void print() {
        System.out.println("\n***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
        }
        System.out.println("Total cost: $" + this.totalCost());
        System.out.println("***************************************************\n");
    }

    public boolean filterMedia(int id) {
        boolean found = false;
        int qty = 0;
        float cost = 0f;
        System.out.println("\n******************SEARCH RESULT********************");
        System.out.println("Product ID: " + id);
        for (Media medium : this.itemsOrdered) {
            if (medium.getID() == id) {
                System.out.println(medium.getDetails() + "\n");
                qty++;
                cost = medium.getCost();
                found = true;
            }
        }
        if (found) {
            System.out.println("Total number of product " + id + " found: " + qty);
            System.out.println("Total cost for these products: $" + (cost * qty));
        } else {
            System.out.println("Such product is not in the cart.");
        }
        System.out.println("***************************************************\n");
        return found;
    }

    public boolean filterMedia(String title) {
        boolean found = false;
        int qty = 0;
        float cost = 0f;
        System.out.println("\n******************SEARCH RESULT********************");
        System.out.println("Product title: " + title);
        for (Media medium : this.itemsOrdered) {
            if (medium.search(title)) {
                System.out.println(medium.getDetails() + "\n");
                qty++;
                cost = medium.getCost();
                found = true;
            }
        }
        if (found) {
            System.out.println("Total number of product " + title + " found: " + qty);
            System.out.println("Total cost for these products: $" + (cost * qty));
        } else {
            System.out.println("Such product is not in the cart!");
        }
        System.out.println("***************************************************\n");
        return found;
    }

    public Media searchMedia(String title) {
        for (Media medium : this.itemsOrdered) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public void sortByTitle() {
        FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public int getSize() {
        return this.itemsOrdered.size();
    }

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void empty() {
        this.itemsOrdered.clear();
    }
}
