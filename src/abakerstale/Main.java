package abakerstale;

import gui.GameScreen;
import mobiles.Player;
import playerstuff.Inventory;
import playerstuff.Item;
import world.World;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        World w = new World(20,15);
        GameScreen g = new GameScreen(w);
    }
}
