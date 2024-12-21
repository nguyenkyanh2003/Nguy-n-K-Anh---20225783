package hust.soict.hedspi.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.exception.*;

public class Track implements Playable {
    private String title;
    private int length;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track that = (Track) obj;
        return this.length == that.length && this.title.equalsIgnoreCase(that.title);
    }

    @Override
    public void play() throws PlayerException {
        if (this.length <= 0) {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);

        showPlaybackDialog();
    }

    private void showPlaybackDialog() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();

        JLabel label1 = new JLabel("Now playing: " + this.title);
        JLabel label2 = new JLabel("Track length: " + this.length);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(label1);
        panel.add(label2);
        panel.add(Box.createVerticalGlue());

        dialog.setTitle("Media Player");
        dialog.add(panel);
        dialog.setSize(300, 150);

        int x = (screenSize.width - dialog.getWidth()) / 2;
        int y = (screenSize.height - dialog.getHeight()) / 2;
        dialog.setLocation(x, y);
        dialog.setVisible(true);
    }

    // Constructors
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track(String title) {
        this(title, 0);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}