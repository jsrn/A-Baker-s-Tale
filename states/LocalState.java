package states;

import abakerstale.Constants;
import abakerstale.Globals;
import abakerstale.Keys;
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

                frameGraphics.drawImage(cells[x][y].getImage(), x * tilewidth, y * tilewidth, null);

                if (cells[x][y].hasItem()) {
                    frameGraphics.drawImage(cells[x][y].getItem().getImage(), x * tilewidth, y * tilewidth, null);
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
                actionKeyPressed();
                Globals.pressedKeys[Keys.SPACE] = false;
                break;
            case Keys.ENTER:
                actionKeyPressed();
                Globals.pressedKeys[Keys.ENTER] = false;
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }
    
    private void actionKeyPressed(){
        if(!textBoxes.isEmpty()){
            textBoxes.removeFirst();
        } else {
            playerAction();
        }
    }

    private void playerAction() {
        Cell facingCell = Globals.PLAYER.getFacingCell();
        
        if (facingCell.hasItem()) {
            System.out.println("Interacting with: " + facingCell.getItem().toString());
            AddTextBox(new TextBox("The quick brown fox"));
        }

    }

    public void AddTextBox(TextBox t) {
        textBoxes.add(t);
    }

    public void RemoveTextBox(TextBox t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
