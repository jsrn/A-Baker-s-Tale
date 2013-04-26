package abakerstale;

import gui.GamePanel;
import javax.swing.JFrame;
import states.InventoryState;
import states.LocalState;
import states.StateMachine;
import world.Cell;
import world.World;

public class Main {

    public Main() {
        Globals.WORLD = new World();
        Globals.stateMachine = new StateMachine();
        Globals.stateMachine.Add("localmap", new LocalState());
        Globals.stateMachine.Add("inventorystate", new InventoryState());

        Globals.stateMachine.Change("localmap");


        setUpGameFrame();

        while (true) {
            try {
                Thread.sleep(1000 / Constants.FRAMES_PER_SECOND);
                updateGame();
                displayGame();
            } catch (InterruptedException ex) {
                System.err.println("Something happened!");
                ex.printStackTrace();
            }
        }
    }

    private void updateGame() {
        for (int i = 0; i < Globals.pressedKeys.length; i++) {
            if (Globals.pressedKeys[i] == true) {
                handleKeypress(i);
            }
        }
    }

    private void displayGame() {
        Globals.stateMachine.Render();
        Globals.gamePanel.repaint();
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
                Globals.stateMachine.Change("inventorystate");
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

    public void openInventory() {
        System.out.println("Opening inventory");
        Globals.WINDOW_MODE = Constants.WINDOW_INVENTORY;
    }

    public void closeInventory() {
        System.out.println("Closing inventory");
        Globals.WINDOW_MODE = Constants.WINDOW_NORMAL;
    }

    private void setUpGameFrame() {
        JFrame gameJFrame = new JFrame();

        gameJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gameJFrame.setTitle("A Baker's Tale");
        gameJFrame.setSize(500, 400);
        gameJFrame.setResizable(false);
        gameJFrame.setLayout(null);
        Globals.gamePanel = new GamePanel();
        Globals.gamePanel.setFocusable(true);
        Globals.gamePanel.setBounds(0, 0, 500, 400);

        gameJFrame.add(Globals.gamePanel);

        gameJFrame.setLocationRelativeTo(null);
        gameJFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
