/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import world.Cell;
import world.World;
import abakerstale.*;


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
        paintGameScreen(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.black);
        g2d.drawLine(500, 0, 500, 400);
    }

    private void paintGameScreen(Graphics g){
        paintWorld(g);
        
        // Inventory
        if(Globals.WINDOW_MODE == Constants.WINDOW_INVENTORY){
            paintInventory(g);
        }
    }
    
    private void paintWorld(Graphics g){
        Cell [][] cells = world.getCells();
        for (int i = 0; i < world.getWorldHeight(); i++) {
            for (int j = 0; j < world.getWorldWidth(); j++) {

                g.drawImage(image, j*tilewidth, i*tilewidth, null); // see javadoc for more info on the parameters

                if(cells[j][i].hasPlayer()){
                    g.drawImage(world.getPlayer().getImage(), j*tilewidth, i*tilewidth, null);
                }
            }
        }
    }

    private void paintInventory(Graphics g){
       System.out.println("Drawing inventory");
    }
}
