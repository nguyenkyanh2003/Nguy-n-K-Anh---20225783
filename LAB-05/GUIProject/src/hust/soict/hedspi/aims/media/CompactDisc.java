package hust.soict.hedspi.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.exception.*;

public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, director, cost);
        this.artist = artist != null ? artist : "Unknown Artist";  // Default to "Unknown Artist" if artist is null
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        this(title, category, artist, "Unknown Director", cost);  // Default director
    }

    public CompactDisc(String title, String category, float cost) {
        this(title, category, "Unknown Artist", "Unknown Director", cost);  // Default artist and director
    }

    public CompactDisc(String title, String category) {
        this(title, category, "Unknown Artist", "Unknown Director", 0.0f);  // Default artist, director, and cost
    }

    public CompactDisc(String title) {
        this(title, "Unknown Category", "Unknown Artist", "Unknown Director", 0.0f);  // Default category, artist, and director
    }

    public void addTrack(Track track) throws DupplicatedItemException {
        if (this.tracks.contains(track)) {
            throw new DupplicatedItemException("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
        } else {
            this.tracks.add(track);
            System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
        }
    }

    public void removeTrack(Track track) throws NonExistingItemException {
        if (this.tracks.remove(track)) {
            System.out.println("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
        } else {
            throw new NonExistingItemException("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
        }
    }

    public int getLength() {
        return this.tracks.stream().mapToInt(Track::getLength).sum();
    }

    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            System.out.println("Playing CD: " + this.getTitle());
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel("Now playing: " + this.getTitle());
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250, 100);
            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            d.setLocation(x, y);
            d.setVisible(true);

            for (Track track : this.tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    System.out.println("Skipping track: " + track.getTitle() + " due to error: " + e.getMessage());
                }
            }
        }
    }

    public String getType() {
        return "CD";
    }

    public String getDetails() {
        StringJoiner tracklist = new StringJoiner(", ");
        this.tracks.forEach(track -> tracklist.add(track.getTitle()));
        
        return "Product ID: " + this.getID()
                + "\n" + "\t" + "Title: " + this.getTitle()
                + "\n" + "\t" + "Category: " + this.getCategory()
                + "\n" + "\t" + "Artist: " + this.artist
                + "\n" + "\t" + "Director: " + this.getDirector()
                + "\n" + "\t" + "Tracklist: " + tracklist
                + "\n" + "\t" + "Length: " + this.getLength() + " minutes"
                + "\n" + "\t" + "Price: $" + this.getCost();
    }

    public String getArtist() {
        return artist;
    }
}
