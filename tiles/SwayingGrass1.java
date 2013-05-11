package tiles;

import abakerstale.Globals;
import java.awt.image.BufferedImage;

public class SwayingGrass1 extends BaseTile {
    
    public BufferedImage getTile(){
        int time = Globals.frameCount;
        int offset;
        if(time < 15){
            offset = 0;
        } else if (time < 30){
            offset = 26;
        } else if (time < 45){
            offset = 52;
        } else {
            offset = 78;
        }
            
        return Globals.TILEMAP.SWAYINGGRASS1.getSubimage(offset, 0, 25, 25);
    }
    
}
