package gui;

import java.awt.Graphics;
import world.World;
import abakerstale.Constants;

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
        
        switch (keycode) {
            case Constants.UP: // up
                world.movePlayerNorth(1);
                break;
            case Constants.DOWN: // down
                world.movePlayerSouth(1);
                break;
            case Constants.LEFT: // left
                world.movePlayerWest(1);
                break;
            case Constants.RIGHT: // right
                world.movePlayerEast(1);
                break;
            case Constants.I:
                // Open inventory
                System.out.println("Opening inventory");
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        //Paint game border
        gamePanel.repaint();
        //inventoryPanel.repaint();
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Baker's Tale");
        setSize(500, 400);
        setResizable(false);
        setLayout(null);
        gamePanel = new GamePanel(world, tilewidth);
        gamePanel.setFocusable(true);
        gamePanel.setBounds(0, 0, 700, 400);

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
