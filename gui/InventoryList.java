package gui;

import abakerstale.Constants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;

public class InventoryList {
    
    private int x, y;

    private LinkedList<InventoryItem> listItems = new LinkedList();
    
    public InventoryList(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void addItem(InventoryItem i){
        listItems.add(i);
    }
    
    public BufferedImage getFrame(){
        BufferedImage frame = new BufferedImage(200, listItems.size()*25, BufferedImage.TYPE_INT_ARGB);
        Graphics g = frame.getGraphics();
        
        int count = 0;
        for (Iterator<InventoryItem> it = listItems.iterator(); it.hasNext();) {
            InventoryItem inventoryItem = it.next();
            g.drawImage(inventoryItem.getFrame(), 0, count*Constants.INV_ITEM_H, null);
            count++;
        }
        return frame;
    }
    
}
