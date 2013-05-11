package tiles;

import abakerstale.Globals;
import java.awt.image.BufferedImage;

public class Grass1 extends BaseTile {
    
    @Override
    public BufferedImage getTile(){
        return Globals.staticAssets.GRASS1;
    }
    
}
