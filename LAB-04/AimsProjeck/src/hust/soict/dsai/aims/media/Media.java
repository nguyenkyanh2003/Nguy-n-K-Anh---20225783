package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
public abstract class Media {
 private int id;
 private String title;
 private String category;
 private float cost;
 
 public static final Comparator<Media> compareByTitleCost = 
		 new MediaComparatorByTitleCost();
 public static final Comparator<Media> compareByCostTitle = 
		 new MediaComparatorByCostTitle();
 public Media (int id,String title , String category, float cost)
 {
	 super();
	 this.id = id;
	 this.title = title;
	 this.category = category;
	 this.cost = cost;
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public boolean equals(Object obj)
{
	if(obj instanceof Media)
	{
		Media media = (Media) obj;
		if(this.id == media.id)
		{
			return true;
		}
	}
	return false;
	}
public static void main(String[] args) {
	ArrayList<Media> media = new ArrayList<>();
	
	CompactDisc cd = new CompactDisc(1, "Anh on ma", "GEN24",12.4f);
	DigitalVideoDisc dvd = new DigitalVideoDisc(3,"One peice","Oda",222.22f);
	Book book = new Book(2,"Cong chua ngu trong rung","Ngu Ngon",33f);
	
	//add
	media.add(cd);
	media.add(dvd);
	media.add(book);
	
    Collections.sort(media, Media.compareByTitleCost);  
	
    for (Media media1: media)
    {
    	System.out.println(media1.toString());
    }
	
	
	
}
 
 
}
