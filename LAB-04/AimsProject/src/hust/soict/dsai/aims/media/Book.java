package hust.soict.dsai.aims.media;
import java.util.*;
public class Book extends Media {
private List<String> authors = new ArrayList<>();
public Book(int id,String title, String category,float cost)
{
	super(id, title, category, cost);
	
}
public Book(int id, String title, String category, float cost, List<String> authors) {
	super(id, title, category, cost);
	this.authors = authors;
}
public List<String>getAuthors()
{
  return authors;	
}
public void setAuthor(List<String> authors)
{
	this.authors = authors;
	}
public void addAuthor(String authorName)
{
  if(!authors.contains(authorName))
  {
	  authors.add(authorName);
	  System.out.println(authorName+"Has been added to the list!");
	  }
  System.out.println(authorName+" is already in the list");
}
public void removeAuthor(String authorName )
{
  if(!authors.contains(authorName))
  {
	  System.out.println(authorName+"is not in the List");
  }
  else
  {
	  authors.remove(authorName);
	  System.out.println(authorName + "has been removed from the list.");
	  
  }
}
public String toString()
{
 return "ID: " + getId() + ". Book: "+getTitle() + " - " +	getCategory()
 +" - $" + getCost();
		 
}
} 
