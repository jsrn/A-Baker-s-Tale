package abakerstale;

import gui.GameJFrame;
import world.World;

public class Main {
    
    public Main(){
        Globals.WORLD = new World();
        GameJFrame gameJFrame = new GameJFrame();
    }

    public static void main(String[] args) {
        new Main();
    }
}
