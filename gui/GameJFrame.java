package gui;

import abakerstale.Globals;
import abakerstale.Constants;
import java.awt.Graphics;
import javax.swing.JFrame;
import world.Cell;

public class GameJFrame {

    private GamePanel gamePanel;

    public GameJFrame() {

        JFrame gameJFrame = new JFrame();

        gameJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gameJFrame.setTitle("A Baker's Tale");
        gameJFrame.setSize(500, 400);
        gameJFrame.setResizable(false);
        gameJFrame.setLayout(null);
        gamePanel = new GamePanel();
        gamePanel.setFocusable(true);
        gamePanel.setBounds(0, 0, 500, 400);

        gameJFrame.add(gamePanel);

        gameJFrame.setLocationRelativeTo(null);
        gameJFrame.setVisible(true);

        // Set up key listener for player input
        gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {

            //public void keyPressed(java.awt.event.KeyEvent evt) {
            //    gamePanelKeyPressed(evt);
            //}
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = true;
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = false;
            }
        });

    }

    private void gamePanelKeyPressed(java.awt.event.KeyEvent evt) {
        int keycode = evt.getKeyCode();
        handleKeypress(keycode);
        gamePanel.repaint();
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
                Globals.PLAYER.setDirection(Constants.DIRECTION_NORTH);
                Globals.PLAYER.goNorth(1);
                break;
            case Constants.KEY_DOWN:
                Globals.PLAYER.setDirection(Constants.DIRECTION_SOUTH);
                Globals.PLAYER.goSouth(1);
                break;
            case Constants.KEY_LEFT:
                Globals.PLAYER.setDirection(Constants.DIRECTION_WEST);
                Globals.PLAYER.goWest(1);
                break;
            case Constants.KEY_RIGHT:
                Globals.PLAYER.setDirection(Constants.DIRECTION_EAST);
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
        if (cell.hasItem()) {
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
}
