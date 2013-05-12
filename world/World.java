package world;

import abakerstale.Globals;
import levels.StartArea1;
import mobiles.Player;

public class World {
    
    private Screen currentScreen;
    
    public World(){
        Globals.PLAYER = new Player(1, 5, 5);
        
        Screen screen = new Screen(new StartArea1());
        
        currentScreen = screen;
    }
    
    public Screen getCurrentScreen(){
        return currentScreen;
    }

}
