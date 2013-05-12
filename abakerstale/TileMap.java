package abakerstale;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import tiles.*;

public class TileMap {
    
    // Other Art Assets
    public BufferedImage MAINMENU;

    // Mapped tiles
    Map<Integer, BaseTile> TILESET = new HashMap();
    public BufferedImage GRASS1;
    public BufferedImage BOULDER1;
    public BufferedImage SWAYINGGRASS1;
    public BufferedImage WOODENCHEST1;
    public BufferedImage WOODENCHESTOPEN1;
    public BufferedImage HORIZONTALWOODENFENCE1;
    public BufferedImage VERTICALWOODENFENCE1;
    public BufferedImage TILESET_OUTSIDE1;
    public BufferedImage NWWOODENFENCECORNER;
    public BufferedImage SWWOODENFENCECORNER;
    public BufferedImage SEWOODENFENCECORNER;
    public BufferedImage NEWOODENFENCECORNER;

    public TileMap() {
        try {
            // Other art assets
            MAINMENU = ImageIO.read(new File("src/art/mainmenu.png"));
            // Mapped tiles
            TILESET_OUTSIDE1 = ImageIO.read(new File("src/art/tileset_outside1.png"));
            GRASS1 = spriteFromTileset(0, 0);
            BOULDER1 = spriteFromTileset(4, 2);
            SWAYINGGRASS1 = spriteFromTileset(0, 2, 4, 1);
            WOODENCHEST1 = spriteFromTileset(0, 3);
            HORIZONTALWOODENFENCE1 = spriteFromTileset(1, 1);
            VERTICALWOODENFENCE1 = spriteFromTileset(0, 1);
            NWWOODENFENCECORNER = spriteFromTileset(2, 1);
            SWWOODENFENCECORNER = spriteFromTileset(4, 1);
            SEWOODENFENCECORNER = spriteFromTileset(5, 1);
            NEWOODENFENCECORNER = spriteFromTileset(3, 1);
            WOODENCHESTOPEN1 = spriteFromTileset(1, 3);
        } catch (IOException ex) {
            System.err.println("Problem loading art asset.");
        }


        TILESET.put(1, new StaticTile(GRASS1));
        TILESET.put(2, new StaticTile(BOULDER1));
        TILESET.put(3, new SwayingGrass1());
        TILESET.put(4, new StaticTile(WOODENCHEST1));
        TILESET.put(5, new StaticTile(HORIZONTALWOODENFENCE1));
        TILESET.put(6, new StaticTile(VERTICALWOODENFENCE1));
        TILESET.put(7, new StaticTile(NWWOODENFENCECORNER));
        TILESET.put(8, new StaticTile(SWWOODENFENCECORNER));
        TILESET.put(9, new StaticTile(SEWOODENFENCECORNER));
        TILESET.put(10, new StaticTile(NEWOODENFENCECORNER));
        TILESET.put(11, new StaticTile(WOODENCHESTOPEN1));
    }

    private BufferedImage spriteFromTileset(int x, int y) {
        return TILESET_OUTSIDE1.getSubimage(rC(x), rC(y), 25, 25);
    }

    private BufferedImage spriteFromTileset(int x, int y, int w, int h) {
        return TILESET_OUTSIDE1.getSubimage(rC(x), rC(y), rC(w), rC(h));
    }

    private int rC(int c) {
        return 25 * c + c;
    }

    public BaseTile getTile(int key) {
        return TILESET.get(key);
    }
}
