package abakerstale;

import mobiles.Player;
import playerstuff.Inventory;
import playerstuff.Item;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addItem("test", 1);
        inv.listItems();
        inv.addItem("derp", 2);
        inv.listItems();
        inv.addItem("test", 4);
        inv.listItems();
    }
}
