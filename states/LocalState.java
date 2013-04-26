package states;

import abakerstale.Constants;
import abakerstale.Globals;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import world.Cell;

public class LocalState implements IState {

    public void Update(float elapsedTime) {
    }

    public void Render() {
        BufferedImage frame = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics frameGraphics = frame.getGraphics();
        int tilewidth = Constants.TILE_WIDTH;
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {

                frameGraphics.drawImage(cells[x][y].getImage(), x * tilewidth, y * tilewidth, null);

                if (cells[x][y].hasItem()) {
                    frameGraphics.drawImage(cells[x][y].getItem().getImage(), x * tilewidth, y * tilewidth, null);
                }

                if (x == Globals.PLAYER.getX() && y == Globals.PLAYER.getY()) {
                    frameGraphics.drawImage(Globals.PLAYER.getImage(), x * tilewidth, y * tilewidth, null);
                }
            }
        }
        Globals.gamePanel.getGraphics().drawImage(frame, 0, 0, null);
    }

    public void OnEnter() {
    }

    public void OnExit() {
    }

    public void Keypress(int keycode) {
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
}
