package states;

import abakerstale.Globals;
import abakerstale.Keys;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class InventoryState extends MenuState {

    @Override
    public void Render() {
        BufferedImage frame = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics frameGraphics = frame.getGraphics();
        
        Graphics2D g2d = (Graphics2D) frameGraphics;
        // Background
        g2d.setColor(GUI_BACKGROUND);
        g2d.fillRect(25, 25, 450, 325);
        // Border
        g2d.setColor(GUI_BORDER);
        g2d.drawRect(25, 25, 450, 325);
        g2d.drawLine(25, 45, 475, 45);
        // Labels
        g2d.setColor(GUI_TEXT);
        frameGraphics.drawString("Inventory", 30, 40);
        
        Globals.gamePanel.getGraphics().drawImage(frame, 0, 0, null);
    }

    @Override
    public void Keypress(int keycode) {
        switch (keycode) {
            case Keys.ESC: // up
                Globals.stateMachine.Change("localmap");
                break;
            default:
                System.out.println("Unregistered keycode: " + keycode);
                break;
        }
    }
}
