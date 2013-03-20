package world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cell {
    BufferedImage image;
    Item item;
    private boolean passable = true;
    
    public Cell(){
        item = null;
        
        try {
            image = ImageIO.read(new File("src/art/tile_grass1.png"));
        } catch (IOException ex) {
            System.out.println("Failed loading image.");
        }
    }
    
    public boolean hasItem(){
        return item != null;
    }
    
    public void addItem(Item item){
        this.item = item;
    }
    
    public Item getItem(){
        return item;
    }
    
    public BufferedImage getImage(){
        return image;
    }
    
    public void setPassable(boolean p){
        passable = p;
    }
    
    public boolean isPassable(){
        return passable;
    }
       
}


/*
 * package world;

import java.util.Iterator;
import java.util.LinkedList;
import mobiles.Mobile;
import mobiles.Player;
import playerstuff.Item;

/**The world is made of cells. Each cell contains important data about itself.
 * The cell class is extended by different types of cell.
 
public class Cell {

    private int x, y;
    private boolean passable;
    private LinkedList<Mobile> inhabitants;
    private LinkedList<Item> items;
    private String rep = " ";

    public Cell() {
        inhabitants = new LinkedList();
        items = new LinkedList();
    }

    public boolean hasPlayer() {
        for (Iterator<Mobile> it = inhabitants.iterator(); it.hasNext();) {
            Mobile mobile = it.next();
            if (mobile instanceof Player) {
                return true;
            }
        }
        return false;
    }

    public Item getItem() {
        if (items.isEmpty()) {
            return new Item("Blank item",1,"i");
        } else {
            return items.getFirst();
        }
    }

    public String getRep() {
        if (inhabitants.isEmpty()) {
            if (items.isEmpty()) {
                return rep;
            } else {
                return items.getFirst().getRep();
            }

        } else {
            return inhabitants.getFirst().getRep();
        }
    }

    public void addMobile(Mobile m) {
        inhabitants.add(m);
    }

    public void addItem(Item i) {
        items.add(i);
    }

    void removeInhabitant(Mobile m) {
        inhabitants.remove(m);
    }
}

 * 
 * 
 */