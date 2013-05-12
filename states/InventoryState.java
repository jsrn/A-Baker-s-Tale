package states;

import abakerstale.Constants;
import abakerstale.Globals;
import abakerstale.Keys;
import gui.InventoryItem;
import gui.InventoryList;
import gui.TextBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;

public class InventoryState implements IState {

    public void Render() {
        BufferedImage frame = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics frameGraphics = frame.getGraphics();

        Graphics2D g2d = (Graphics2D) frameGraphics;
        // Background
        g2d.setColor(Constants.GUI_BACKGROUND);
        g2d.fillRect(0, 0, 600, 400);
        // Border
        g2d.setColor(Constants.GUI_BORDER);
        g2d.drawLine(0, 25, 600, 25);
        g2d.drawLine(150, 0, 150, 400);
        // Labels
        g2d.setColor(Constants.GUI_TEXT);
        g2d.setFont(new Font( "Monospaced", Font.PLAIN, 12));
        frameGraphics.drawString("Inventory", 5, 15);
        frameGraphics.drawString("Status", 155, 15);

        // Draw inventory list
        LinkedList<String> inventory = Globals.PLAYER.getInventory();
        if (!inventory.isEmpty()) {
            InventoryList iList = new InventoryList(0, 25);

            for (Iterator<String> it = Globals.PLAYER.getInventory().iterator(); it.hasNext();) {
                String string = it.next();
                iList.addItem(new InventoryItem(string));
            }

            g2d.drawImage(iList.getFrame(), 0, 26, null);
        }
        
        // Draw status line
        g2d.drawImage(Globals.TILEMAP.CURRENCYLARGE, 400, 0, null);

        Globals.gamePanel.getGraphics().drawImage(frame, 0, 0, null);
    }

    public void Keypress(int keycode) {
        switch (keycode) {
            case Keys.ESC:
                Globals.stateMachine.Change("localmap");
                break;
            case Keys.I:
                Globals.stateMachine.Change("localmap");
                Globals.pressedKeys[Keys.I] = false;
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }

    public void Update(float elapsedTime) {
    }

    public void OnEnter() {
    }

    public void OnExit() {
    }

    public void AddTextBox(TextBox t) {
    }

    public void RemoveTextBox(TextBox t) {
    }
}
