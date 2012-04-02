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
    private String rep = "_";

    public Cell() {
        inhabitants = new LinkedList();
    }

    public String getRep() {
        if (inhabitants.isEmpty()) {
            return rep;
        } else {
            return inhabitants.getFirst().getRep();
        }
    }

    public void addMobile(Mobile m) {
        inhabitants.add(m);
    }
}
