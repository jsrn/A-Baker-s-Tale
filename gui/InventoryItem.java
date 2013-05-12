package gui;

import abakerstale.Constants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class InventoryItem {
    
    private String name;
    
    public InventoryItem(String n){
        name = n;
    }
        
    public BufferedImage getFrame(){
        BufferedImage frame = new BufferedImage(Constants.INV_ITEM_W, Constants.INV_ITEM_H, BufferedImage.TYPE_INT_ARGB);
        Graphics g = frame.getGraphics();
        g.setColor(Constants.GUI_BACKGROUND);
        g.fillRect(0, 0, Constants.INV_ITEM_W, Constants.INV_ITEM_H);
        g.setColor(Constants.GUI_TEXT);
        g.drawString(name, 5, 17);
        return frame;
    }
    
}
