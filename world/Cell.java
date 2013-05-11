package world;

import abakerstale.Globals;
import events.Event;
import java.awt.image.BufferedImage;
import tiles.BaseTile;

public class Cell {

    BufferedImage image;
    private boolean passable = true;
    public int layer1, layer2;
    private Event event = null;

    public Cell() {
    }

    public void setLayerOne(int l1) {
        layer1 = l1;
    }

    public void setLayerTwo(int l2) {
        layer2 = l2;
    }

    public BufferedImage getLayerOneImage() {
        BaseTile l1 = Globals.TILEMAP.getTile(layer1);
        return l1.getTile();
    }
    
     public BufferedImage getLayerTwoImage() {
        BaseTile l2 = Globals.TILEMAP.getTile(layer2);
        return l2.getTile();
    }

    public void setPassable(boolean p) {
        passable = p;
    }

    public boolean isPassable() {
        return passable;
    }
    
    public void addEvent(Event e){
        event = e;
    }
    
    public boolean hasEvent(){
        return event != null;
    }

    public Event getEvent() {
        return event;
    }
}