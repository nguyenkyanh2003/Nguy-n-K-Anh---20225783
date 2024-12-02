package hust.soict.dsai.aims.media;

public class Track extends CompactDisc implements Playable {
 private String titleTrack;
 private int length;
 
   public Track(int id , String title, String category, float cost, String titleTrack, int length)
   {
	   super(id,title,category,cost);
	   this.titleTrack = titleTrack;
	   this.length = length;
   }
   
   public void play()
   {
	   System.out.println("Playing DVD: "+ this.getTitle());
	   System.out.println("DVD length: " + this.getLength());
   }

public String getTitleTrack() {
	return titleTrack;
}

public void setTitleTrack(String titleTrack) {
	this.titleTrack = titleTrack;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}
   public boolean equals(Object obj)
   {
	   if (obj instanceof Track)
	   {  
		   Track track = (Track) obj;
		   if(this.titleTrack.equals(track.titleTrack)&& this.length == track.length) {
			   return true;
		   }
	   }
	   return false;
   }
}
