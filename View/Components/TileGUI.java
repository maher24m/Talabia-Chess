package View.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * The {@code TileGUI} class represents a Swing JPanel that visually represents
 * a tile on a chessboard
 * in a graphical user interface. It includes methods to retrieve the x and y
 * coordinates of the tile.
 * The appearance of the tile is determined by alternating black and white
 * colors based on its coordinates.
 * Class implemented by Asim Adel Ahmed Maroof
 */
public class TileGUI extends JButton {
    private int x;
    private int y;
    private JLabel imageLabel;
    private String imagePath = "./VIEW/images/";
    private boolean isAvailable = false;

    /**
     * Constructs a new TileGUI instance.
     * Initializes the tile with the specified x and y coordinates and sets its
     * preferred size.
     *
     * @param x The x-coordinate of the tile.
     * @param y The y-coordinate of the tile.
     */
    public TileGUI(int x, int y) {
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(80, 80));
        // set maximum size to preferred size to prevent stretching
        setMaximumSize(new Dimension(90, 90));
        imageLabel = new JLabel();
        add(imageLabel);
    }

    /**
     * Gets the x-coordinate of the tile.
     *
     * @return The x-coordinate of the tile.
     */
    public int getTileX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the tile.
     *
     * @return The y-coordinate of the tile.
     */
    public int getTileY() {
        return y;
    }

    // does not work
    public void setImage(String imagePiece) {
        if (imagePiece != null) {
            ImageIcon imageIcon = new ImageIcon(imagePath + imagePiece + ".png");
            Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);

            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);

            // centering the image
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
        }
    }

    public void flipImage(String imagePiece) {
        if (imagePiece != null) {
            ImageIcon imageIcon = new ImageIcon(imagePath + imagePiece + ".png");
            Image originalImage = imageIcon.getImage();

            if (originalImage.getWidth(null) > 0 && originalImage.getHeight(null) > 0) {
                // Create a BufferedImage with the same dimensions as the original image
                BufferedImage bufferedImage = new BufferedImage(originalImage.getWidth(null),
                originalImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bufferedImage.createGraphics();

                // Rotate the image by 180 degrees
                g2d.rotate(Math.PI, originalImage.getWidth(null) / 2, originalImage.getHeight(null) / 2);
                g2d.drawImage(originalImage, 0, 0, null);
                g2d.dispose();

                // Update the imageIcon with the rotated image
                ImageIcon rotatedImageIcon = new ImageIcon(bufferedImage);
                imageLabel.setIcon(rotatedImageIcon);

                // Centering the image
                imageLabel.setHorizontalAlignment(JLabel.CENTER);
                imageLabel.setVerticalAlignment(JLabel.CENTER);

            } else {
                System.out.println("Image not found");
            }
        }
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setAvailable(boolean isClicked) {
        this.isAvailable = isClicked;
        repaint();
    }

    /**
     * Overrides the paintComponent method to customize the appearance of the tile.
     * Alternates the background color of the tile between black and white based on
     * its coordinates.
     *
     * @param g The Graphics context used for painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        if (isAvailable) {
            setBackground(Color.GREEN);
        } else {
            setBackground((x + y) % 2 == 0 ? Color.BLACK : Color.WHITE);
        }

        super.paintComponent(g);

    }
}
