package world;

import java.util.Iterator;
import java.util.List;

public class ScreenJSON {

    private String id, base_terrain;
    private List<Item> items;

    public String getScreenID() {
        return id;
    }

    public String getBaseTerrain() {
        return base_terrain;
    }

    public List<Item> getItems() {
        return items;
    }
    
    public String toString(){
        String s = "ID: " + id;
        s += "\nBase Terrain: " + base_terrain;
        s += "\nItems:";
        for (Iterator<Item> it = items.iterator(); it.hasNext();) {
            Item item = it.next();
            s += "\n - " + item;
        }
        return s;
    }
}
