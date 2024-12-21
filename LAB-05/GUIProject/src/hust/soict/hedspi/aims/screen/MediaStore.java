package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new AddToCartListener());
        container.add(addToCartButton);

        JButton detailsButton = new JButton("View details");
        detailsButton.addActionListener(new DetailsListener());
        container.add(detailsButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new PlayButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel();
            JDialog dialog = new JDialog();
            JLabel label = new JLabel();
            try {
                cart.addMedia(media);
                label.setText(media.getTitle() + " added to cart.");
            } catch (CartFullException ex) {
                label.setText("The cart is full.");
            } finally {
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(Box.createVerticalGlue());
                panel.add(label);
                panel.add(Box.createVerticalGlue());
                dialog.add(panel);
                dialog.setSize(250, 100);
                centerDialog(dialog);
                dialog.setVisible(true);
            }
        }
    }

    private class PlayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ((Disc) media).play();
            } catch (PlayerException ex) {
                showErrorDialog(media.getTitle() + " cannot be played.", "Media length is non-positive.");
            }
        }
    }

    private class DetailsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel();
            JDialog dialog = new JDialog();
            JLabel label = new JLabel("<html>" + media.getDetails().replaceAll("\n", "<br/>") + "</html>", SwingConstants.CENTER);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(Box.createVerticalGlue());
            panel.add(label);
            panel.add(Box.createVerticalGlue());
            dialog.add(panel);
            dialog.setSize(300, 200);
            centerDialog(dialog);
            dialog.setVisible(true);
        }
    }

    private void showErrorDialog(String... messages) {
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (String message : messages) {
            JLabel label = new JLabel(message);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
        }
        panel.add(Box.createVerticalGlue());
        dialog.add(panel);
        dialog.setSize(300, 150);
        centerDialog(dialog);
        dialog.setVisible(true);
    }

    private void centerDialog(JDialog dialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - dialog.getWidth()) / 2;
        int y = (screenSize.height - dialog.getHeight()) / 2;
        dialog.setLocation(x, y);
    }
}
