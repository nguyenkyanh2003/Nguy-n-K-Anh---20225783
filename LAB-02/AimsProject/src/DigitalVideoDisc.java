


public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id =  nbDigitalVideoDiscs++;
	}
	

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;
	}

	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
//	public String toString() {
//		return "Title: " + title + ", Cost: $" + cost;
//	
//	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getId() {
		return id+1;
	}

	public String toString()
	{
		return String.format(getId()+". "+getTitle()+" - " + getCategory()+" - "+ getDirector()
		+ " - " + getLength()+ " - " + getCost());
	}
	
 public boolean isMatch(int id)
 {
	 return this.id == id;
 }
 public boolean isMatch(String title)
 {
	 return this.title.toLowerCase().contains(title.toLowerCase());
 }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((category == null) ? 0 : category.hashCode());
	result = prime * result + Float.floatToIntBits(cost);
	result = prime * result + ((director == null) ? 0 : director.hashCode());
	result = prime * result + id;
	result = prime * result + length;
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DigitalVideoDisc other = (DigitalVideoDisc) obj;
	if (category == null) {
		if (other.category != null)
			return false;
	} else if (!category.equals(other.category))
		return false;
	if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
		return false;
	if (director == null) {
		if (other.director != null)
			return false;
	} else if (!director.equals(other.director))
		return false;
	if (id != other.id)
		return false;
	if (length != other.length)
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	return true;
}
 
}

