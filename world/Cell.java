package world;

import abakerstale.TileMap;
import java.awt.image.BufferedImage;
import tiles.BaseTile;

public class Cell {

    BufferedImage image;
    Item item;
    private boolean passable = true;
    public int layer1, layer2;

    public Cell() {
        item = null;
    }

    public void setLayerOne(int l1) {
        layer1 = l1;
    }

    public void setLayerTwo(int l2) {
        layer2 = l2;
    }

    public boolean hasItem() {
        return item != null;
    }

    public void addItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public BufferedImage getLayerOneImage() {
        BaseTile l1 = TileMap.layerOne[layer1];
        BufferedImage l1i = l1.getTile();
        return l1i;
    }
    
     public BufferedImage getLayerTwoImage() {
        BaseTile l2 = TileMap.layerTwo[layer2];
        BufferedImage l2i = l2.getTile();  
        return l2i;
    }

    public void setPassable(boolean p) {
        passable = p;
    }

    public boolean isPassable() {
        return passable;
    }
}