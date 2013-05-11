package tiles;

import java.awt.image.BufferedImage;

public class StaticTile extends BaseTile{
    
    BufferedImage image;
    
    public StaticTile(BufferedImage i){
        image = i;
    }
    
    @Override
    public BufferedImage getTile(){
        return image;
    }
    
}
