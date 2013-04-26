package states;

import abakerstale.Constants;
import abakerstale.Globals;
import abakerstale.Keys;
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
            case Keys.UP:
                Globals.PLAYER.setDirection(Constants.DIRECTION_NORTH);
                Globals.PLAYER.goNorth(1);
                break;
            case Keys.DOWN:
                Globals.PLAYER.setDirection(Constants.DIRECTION_SOUTH);
                Globals.PLAYER.goSouth(1);
                break;
            case Keys.LEFT:
                Globals.PLAYER.setDirection(Constants.DIRECTION_WEST);
                Globals.PLAYER.goWest(1);
                break;
            case Keys.RIGHT:
                Globals.PLAYER.setDirection(Constants.DIRECTION_EAST);
                Globals.PLAYER.goEast(1);
                break;
            case Keys.I:
                Globals.stateMachine.Change("inventorystate");
                break;
            case Keys.SPACE:
                playerAction();
                Globals.pressedKeys[Keys.SPACE] = false;
                break;
            case Keys.ENTER:
                playerAction();
                Globals.pressedKeys[Keys.ENTER] = false;
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }

    private void playerAction() {
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();

        int newY = Globals.PLAYER.getY();
        int newX = Globals.PLAYER.getX();
        switch ( Globals.PLAYER.getDirection() ) {
            case Constants.DIRECTION_NORTH:
                newY = Globals.PLAYER.getY() - 1;
                break;
            case Constants.DIRECTION_SOUTH:
                newY = Globals.PLAYER.getY() + 1;
                break;
            case Constants.DIRECTION_EAST:
                newX = Globals.PLAYER.getX() + 1;
                break;
            case Constants.DIRECTION_WEST:
                newX = Globals.PLAYER.getX() - 1;
                break;
        }

        Cell cell = cells[newX][newY];
        if (cell.hasItem()) {
            System.out.println("Interacting with: " + cell.getItem().toString());
        }

    }
}
