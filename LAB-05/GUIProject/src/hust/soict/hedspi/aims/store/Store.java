package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import hust.soict.hedspi.aims.exception.*;
import hust.soict.hedspi.aims.media.*;
import java.time.LocalDate;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();

    // Add media to store
    public void addMedia(Media medium) throws DupplicatedItemException {
        if (medium == null || medium.getTitle() == null || medium.getTitle().trim().isEmpty()) {
            throw new DupplicatedItemException("Cannot add media with invalid or empty title.");
        }
        for (Media existingMedium : itemsInStore) {
            if (existingMedium.getTitle().equalsIgnoreCase(medium.getTitle())) {
                throw new DupplicatedItemException(medium.getTitle() + " already exists in the store.");
            }
        }
        medium.setDateAdded(LocalDate.now());
        this.itemsInStore.add(medium);
        System.out.println(medium.getTitle() + " has been added to the store.");
    }

    // Remove media from store
    public void removeMedia(Media medium) throws NonExistingItemException {
        if (this.itemsInStore.remove(medium)) {
            System.out.println(medium.getTitle() + " has been removed from the store.");
        } else {
            throw new NonExistingItemException(medium.getTitle() + " is not available in the store.");
        }
    }

    // Search for media by title
    public Media searchMedia(String title) {
        for (Media medium : this.itemsInStore) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    // Print available media in store
    public void print() {
        System.out.println("\n*************AVAILABLE MEDIA IN STORE**************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).getTitle() + "\t-\t" + itemsInStore.get(i).getType());
        }
        System.out.println("***************************************************\n");
    }

    // Get items in store (Unmodifiable list to preserve encapsulation)
    public List<Media> getItemsInStore() {
        return Collections.unmodifiableList(this.itemsInStore);
    }
}
