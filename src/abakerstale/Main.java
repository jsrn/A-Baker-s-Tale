package abakerstale;

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
        m.setName("derp");
        System.out.println(m);
        m.listBodyParts();

    }

}
