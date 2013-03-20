package gui;

import abakerstale.Globals;
import abakerstale.Constants;
import java.awt.Graphics;
import world.World;
import world.Cell;

public class GameJFrame extends javax.swing.JFrame {

    private GamePanel gamePanel;

    public GameJFrame() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Baker's Tale");
        setSize(500, 400);
        setResizable(false);
        setLayout(null);
        gamePanel = new GamePanel();
        gamePanel.setFocusable(true);
        gamePanel.setBounds(0, 0, 500, 400);

        add(gamePanel);

        setVisible(true);

        // Set up key listener for player input
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                gamePanelKeyPressed(evt);
            }
        });

    }

    private void gamePanelKeyPressed(java.awt.event.KeyEvent evt) {

        int keycode = evt.getKeyCode();
        handleKeypress(keycode);

        repaint();
    }

    public void openInventory() {
        System.out.println("Opening inventory");
        Globals.WINDOW_MODE = Constants.WINDOW_INVENTORY;
    }

    public void closeInventory() {
        System.out.println("Closing inventory");
        Globals.WINDOW_MODE = Constants.WINDOW_NORMAL;
    }

    private void handleKeypress(int keycode) {

        switch (Globals.WINDOW_MODE) {
            case Constants.WINDOW_NORMAL:
                handleGameplayKeypress(keycode);
                break;
            case Constants.WINDOW_INVENTORY:
                handleInventoryKeypress(keycode);
                break;
        }

    }

    private void handleGameplayKeypress(int keycode) {
        switch (keycode) {
            case Constants.KEY_UP:
                Globals.PLAYER.goNorth(1);
                break;
            case Constants.KEY_DOWN:
                Globals.PLAYER.goSouth(1);
                break;
            case Constants.KEY_LEFT:
                Globals.PLAYER.goWest(1);
                break;
            case Constants.KEY_RIGHT:
                Globals.PLAYER.goEast(1);
                break;
            case Constants.KEY_I:
                openInventory();
                break;
            case Constants.KEY_SPACE:
                playerAction();
                break;
            case Constants.KEY_ENTER:
                playerAction();
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }

    private void playerAction() {
        System.out.println("Performing player action");
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
        int direction = Globals.PLAYER.getDirection();
        int playerX = Globals.PLAYER.getX();
        int playerY = Globals.PLAYER.getY();

        int newY = playerY;
        int newX = playerX;
        switch (direction) {
            case Constants.DIRECTION_NORTH:
                newY = playerY - 1;
                break;
            case Constants.DIRECTION_SOUTH:
                newY = playerY + 1;
                break;
            case Constants.DIRECTION_EAST:
                newX = playerX + 1;
                break;
            case Constants.DIRECTION_WEST:
                newX = playerX - 1;
                break;
        }
        
        Cell cell = cells[newX][newY];
        if(cell.hasItem()){
            System.out.println("Interacting with: " + cell.getItem().toString());
        }

    }

    private void handleInventoryKeypress(int keycode) {
        switch (keycode) {
            case Constants.KEY_ESC: // up
                closeInventory();
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        //Paint game border
        gamePanel.repaint();

    }
}
