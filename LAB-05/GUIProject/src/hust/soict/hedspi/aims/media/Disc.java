package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media implements Playable {
    private String director;
    private int length;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost);
    }

    public Disc(String title, String category, float cost) {
        this(title, category, "Unknown Director", 0, cost);
    }

    public Disc(String title, String category) {
        this(title, category, "Unknown Director", 0, 0.0f);
    }

    public Disc(String title) {
        this(title, "Unknown Category", "Unknown Director", 0, 0.0f);
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}
