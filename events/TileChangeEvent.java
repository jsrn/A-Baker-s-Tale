package events;

import abakerstale.Globals;
import world.Cell;

public class TileChangeEvent extends Event {
    
    private int x, y, layer, newTileID;
    
    public TileChangeEvent(int x, int y, int layer, int newTileID){
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.newTileID = newTileID;
    }
    
    public void trigger(){
        Cell[][] currentCells = Globals.WORLD.getCurrentScreen().getCells();
        Cell c = currentCells[x][y];
        switch(layer){
            case 1:
                c.layer1 = newTileID;
                break;
            case 2:
                c.layer2 = newTileID;
                break;
        }
    }
    
}
