package abakerstale;

import mobiles.Humanoid;
import mobiles.Player;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing mobile creation
        Player m = new Player(1,2,3);
        System.out.print(m.getId());
        System.out.print(m.getX());
        System.out.print(m.getY());
        System.out.println("");

    }

}
