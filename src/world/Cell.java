package world;

import java.util.LinkedList;
import mobiles.Mobile;

/**The world is made of cells. Each cell contains important data about itself.
 * The cell class is extended by different types of cell.
 */
public class Cell {

    private int x, y;
    private boolean passable;
    private LinkedList<Mobile> inhabitants;

    public Cell(){
        
    }
}
