package abakerstale;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StaticTiles {

    public BufferedImage GRASS1;
    public BufferedImage BOULDER1;
    public BufferedImage SWAYINGGRASS1;
    public BufferedImage WOODENCHEST1;
    public BufferedImage HORIZONTALWOODENFENCE1;
    public BufferedImage VERTICALWOODENFENCE1;
    public BufferedImage TILESET_OUTSIDE1;

    public StaticTiles() {
        try {
            TILESET_OUTSIDE1 = ImageIO.read(new File("src/art/tileset_outside1.png"));
            GRASS1 = spriteFromTileset(0, 0);
            BOULDER1 = spriteFromTileset(4,2);
            SWAYINGGRASS1 = spriteFromTileset(0,2,4,1);
            WOODENCHEST1 = spriteFromTileset(0,3);
            HORIZONTALWOODENFENCE1 = spriteFromTileset(1, 1);
            VERTICALWOODENFENCE1 = spriteFromTileset(0, 1);
        } catch (IOException ex) {
            System.err.println("Problem loading art asset.");
        }
    }

    private BufferedImage spriteFromTileset(int x, int y){
        return TILESET_OUTSIDE1.getSubimage(rC(x), rC(y), 25, 25);
    }
    
    private BufferedImage spriteFromTileset(int x, int y, int w, int h){
        return TILESET_OUTSIDE1.getSubimage(rC(x), rC(y), rC(w), rC(h));
    }
    
    private int rC(int c){
        return 25*c + c;
    }

}
