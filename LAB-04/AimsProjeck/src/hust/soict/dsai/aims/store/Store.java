package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;
public class Store {
private ArrayList<Media> itemsInStore = new ArrayList<Media>();
public void addMedia(Media media)
{
 itemsInStore.add(media);
 System.out.println(media.getTitle() + "Has been added to the store!");
 
}
 public void removeMedia(Media media)
 {
	 boolean check = false;
	 for(Media item : itemsInStore)
	 {
		 if(item.equals(media))
		 {
			 itemsInStore.remove(media);
			 System.out.println(media.getTitle() + "Has beem remove from the store");
			 check = true;
			 break;
		 }
	 }
	 if(!check) System.out.println(media.getTitle()+"is not in the store");
 }
  public ArrayList<Media> getItemsInStore()
  {
	  return itemsInStore;
  }
}
