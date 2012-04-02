/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import world.World;

/**
 *
 * @author James
 */
public class GamePanel extends JPanel {

    BufferedImage image;
    World world;
    int tilewidth;

    public GamePanel(World w, int tilewidth) {
        world = w;
        this.tilewidth = tilewidth;

        try {
            image = ImageIO.read(new File("src/art/tiles/grass1.png"));
        } catch (IOException ex) {
            System.out.println("Failed loading image.");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < world.getWorldSize(); i++) {
            for (int j = 0; j < world.getWorldSize(); j++) {
                g.drawImage(image, i*tilewidth, j*tilewidth, null); // see javadoc for more info on the parameters
            }
        }
    }
}
