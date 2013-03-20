package world;

import abakerstale.Globals;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mobiles.Player;

public class World {
    
    private Screen currentScreen;
    
    public World(){
        Globals.PLAYER = new Player(1, 0, 0);
        
        Screen screen = new Screen("start_area1");
        
        currentScreen = screen;
    }
    
    public Screen getCurrentScreen(){
        return currentScreen;
    }

}
