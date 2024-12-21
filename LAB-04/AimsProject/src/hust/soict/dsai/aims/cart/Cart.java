package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
public class Cart {
 private final int maxNumberOrdered=20;
 private ArrayList<Media> itemsOrdered = new ArrayList<Media>(maxNumberOrdered);
 public void addMedia(Media media)
 {
	 if(itemsOrdered.size()<maxNumberOrdered)
	 {
		 itemsOrdered.add(media);
		 System.out.println(media.getTitle() + "Has been added to the cart!");
	 } 
	 else System.out.println("The cart is full!");
 }
 public void removeMedia (Media media)

		 {
	 boolean check = false;
	 for(Media item : itemsOrdered)
	 {
		 if(item.equals(media))
		 {
			 itemsOrdered.remove(item); 
			 System.out.println(media.getTitle() + "hass been removed from the cart!");
			 check = true;
			 break;
		 }
	 }
	 if(!check) System.out.println(media.getTitle() + "Is not int the cart!");
		 }
 public ArrayList<Media> getItemsInCart()
 {
	 return itemsOrdered;
 }
 public float totalCost()
 {
	 float total = 0.0f;
	 for(int i=0;i<itemsOrdered.size();i++)
	 {
		 total+=itemsOrdered.get(i).getCost();
	 }
	 return total;
 }
 
 public void printCart()
 {
	 System.out.println("--------------CART-------------");
	 System.out.println("Ordered Items");
	 for(int i=0;i<itemsOrdered.size();i++)
	 {
		 System.out.println((i+1) + itemsOrdered.get(i).toString());	 
	 }
	 System.out.println("Total cost: $" + totalCost());
	 System.out.println("--------------------------------");
 }
 public void searchID(int id)
 {
	 boolean check = false;
	 for(int i=0 ; i<itemsOrdered.size();i++)
	 {
		 if(itemsOrdered.get(i).getId() == id)
		 {
			 check = true;
			 System.out.println("DVD found: ");
			 System.out.println(itemsOrdered.get(i).toString());
			 break;
		 }
	 }
	 if(!check) System.out.println("No match is found!");
	 
 }
 public void searchTitle(String title){
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				found = true;
				System.out.println("DVD found: ");
				System.out.println(itemsOrdered.get(i).toString());
				break;
			}
		}
		if (!found) System.out.println("No match is found!");
	}
}
