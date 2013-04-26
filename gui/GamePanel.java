package gui;

import abakerstale.Globals;
import abakerstale.Constants;
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

public class GamePanel extends JPanel {

    BufferedImage image;
    World world;
    int tilewidth = 25;

    public GamePanel() {
        addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = true;
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = false;
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        paintGameScreen(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawLine(500, 0, 500, 400);
    }

    private void paintGameScreen(Graphics g) {
        paintWorld(g);

        // Inventory
        if (Globals.WINDOW_MODE == Constants.WINDOW_INVENTORY) {
            paintInventory(g);
        }
    }

    private void paintWorld(Graphics g) {
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {

                g.drawImage(cells[x][y].getImage(), x * tilewidth, y * tilewidth, null);

                if (cells[x][y].hasItem()) {
                    g.drawImage(cells[x][y].getItem().getImage(), x * tilewidth, y * tilewidth, null);
                }

                if (x == Globals.PLAYER.getX() && y == Globals.PLAYER.getY()) {
                    g.drawImage(Globals.PLAYER.getImage(), x * tilewidth, y * tilewidth, null);
                }
            }
        }
    }

    private void paintInventory(Graphics g) {
        System.out.println("Drawing inventory");
        Graphics2D g2d = (Graphics2D) g;
        // Background
        g2d.setColor(Constants.GUI_BACKGROUND);
        g2d.fillRect(25, 25, 450, 325);
        // Border
        g2d.setColor(Constants.GUI_BORDER);
        g2d.drawRect(25, 25, 450, 325);
        g2d.drawLine(25, 45, 475, 45);
        // Labels
        g2d.setColor(Constants.GUI_TEXT);
        g.drawString("Inventory", 30, 40);
    }
}
