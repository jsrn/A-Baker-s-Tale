package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import world.World;

public class GameScreen extends javax.swing.JFrame {

    private World world;
    private int tilewidth = 25;

    // Interface parts
    GamePanel gamePanel;

    /** Creates new form GameScreen */
    public GameScreen(World w) {
        world = w;
        System.out.println(world);
        System.out.println(w);
        initComponents();
    }

    private void gamePanelKeyPressed(java.awt.event.KeyEvent evt) {

        int keycode = evt.getKeyCode();
        System.out.println(keycode);
        switch (keycode) {
            case 38: // up
                world.movePlayerNorth(1);
                break;
            case 40: // down
                world.movePlayerSouth(1);
                break;
            case 37: // left
                world.movePlayerWest(1);
                break;
            case 39: // right
                world.movePlayerEast(1);
                break;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        // Paint game border
        gamePanel.repaint();
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(510, 0, 510, 400);
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Baker's Tale");
        setSize(700, 400);
        setResizable(false);
        gamePanel = new GamePanel(world, tilewidth);
        gamePanel.setFocusable(true);
        add(gamePanel);
        setVisible(true);

        // Set up key listener for player input
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                gamePanelKeyPressed(evt);
            }
        });

    }
}
