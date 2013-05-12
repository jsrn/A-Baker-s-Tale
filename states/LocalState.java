package states;

import abakerstale.Constants;
import abakerstale.Globals;
import abakerstale.Keys;
import events.EventChain;
import gui.TextBox;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import world.Cell;

public class LocalState implements IState {

    private LinkedList<TextBox> textBoxes = new LinkedList();

    public void Update(float elapsedTime) {
    }

    public void Render() {
        BufferedImage frame = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics frameGraphics = frame.getGraphics();
        int tilewidth = Constants.TILE_WIDTH;
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {

                frameGraphics.drawImage(cells[x][y].getLayerOneImage(), x * tilewidth, y * tilewidth, null);
                if (cells[x][y].layer2 > 0) {
                    frameGraphics.drawImage(cells[x][y].getLayerTwoImage(), x * tilewidth, y * tilewidth, null);
                }

                if (x == Globals.PLAYER.getX() && y == Globals.PLAYER.getY()) {
                    frameGraphics.drawImage(Globals.PLAYER.getImage(), x * tilewidth, y * tilewidth, null);
                }
            }
        }

        for (Iterator<TextBox> it = textBoxes.iterator(); it.hasNext();) {
            TextBox t = it.next();

            frameGraphics.setColor(Constants.GUI_BACKGROUND);
            frameGraphics.fillRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());

            frameGraphics.setColor(Constants.GUI_BORDER);
            frameGraphics.drawRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());

            frameGraphics.setColor(Constants.GUI_TEXT);
            frameGraphics.drawString(t.getText(), t.getX() + 5, t.getY() + 15);

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
                movementKeyPressed(Keys.UP);
                break;
            case Keys.DOWN:
                movementKeyPressed(Keys.DOWN);
                break;
            case Keys.LEFT:
                movementKeyPressed(Keys.LEFT);
                break;
            case Keys.RIGHT:
                movementKeyPressed(Keys.RIGHT);
                break;
            case Keys.I:
                Globals.stateMachine.Change("inventorystate");
                Globals.pressedKeys[Keys.I] = false;
                break;
            case Keys.SPACE:
                actionKeyPressed();
                break;
            case Keys.ENTER:
                actionKeyPressed();
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }

    private void actionKeyPressed() {
        if (!textBoxes.isEmpty()) {
            textBoxes.removeFirst();
        } else {
            playerAction();

        }
        Globals.pressedKeys[Keys.ENTER] = false;
        Globals.pressedKeys[Keys.SPACE] = false;
    }

    private void movementKeyPressed(int keycode) {
        if (textBoxes.isEmpty()) {
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
            }
            Cell playersCell = Globals.PLAYER.getCurrentCell();
            if(playersCell.hasEvent()){
                EventChain e = playersCell.getEvent();
                if(e.getTriggerType().matches("playerStep")){
                    e.run();
                }
            }
        }
    }

    private void playerAction() {
        Cell facingCell = Globals.PLAYER.getFacingCell();

        if(facingCell.hasEvent()){
            EventChain e = facingCell.getEvent();
            if(e.getTriggerType().matches("playerAction")){
                Thread thr1 = new Thread(e);
                thr1.start();
            }
        }
    }

    public void AddTextBox(TextBox t) {
        textBoxes.add(t);
    }

    public void RemoveTextBox(TextBox t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
