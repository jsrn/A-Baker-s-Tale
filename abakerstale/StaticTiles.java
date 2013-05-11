package abakerstale;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class StaticTiles {

    public BufferedImage GRASS1;
    public BufferedImage BOULDER1;

    public StaticTiles() {
        try {
            GRASS1 = ImageIO.read(new File("src/art/tile_grass1.png"));
            BOULDER1 = ImageIO.read(new File("src/art/tile_boulder1.png"));
        } catch (IOException ex) {
            System.err.println("Problem loading art asset.");
        }
    }
}
