package abakerstale;

import javax.swing.JPanel;
import mobiles.Player;
import states.StateMachine;
import world.World;

public class Globals {
    public static int WINDOW_MODE = Constants.WINDOW_NORMAL;
    
    public static World WORLD;
    public static Player PLAYER;
    
    public static boolean [] pressedKeys = new boolean[255];
    
    public static JPanel gamePanel;
    
    public static StateMachine stateMachine;
}
