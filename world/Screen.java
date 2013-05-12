package world;

import events.EventChain;
import java.util.Iterator;
import java.util.LinkedList;
import levels.BaseLevel;

public class Screen {

    private Cell[][] cells = new Cell[20][15];;

    public Screen(BaseLevel level) {
        
        int [] layer1 = level.getLayerOne();
        int [] layer2 = level.getLayerTwo();
        int [] passables = level.getPassableLayer();
        LinkedList<EventChain> events = level.getEvents();
        
        int count = 0;
   
        for (int y = 0; y < 15; y++) {
            for (int x = 0; x < 20; x++) {
                Cell c = new Cell();
                c.setLayerOne(layer1[count]);
                c.setLayerTwo(layer2[count]);
                c.setPassable(passables[count] == 1);
                cells[x][y] = c;
                count++;
            }
        }
        
        for (Iterator<EventChain> it = events.iterator(); it.hasNext();) {
            EventChain event = it.next();
            cells[event.getX()][event.getY()].addEvent(event);
        }
        
    }

    public Cell[][] getCells() {
        return cells;
    }
}
