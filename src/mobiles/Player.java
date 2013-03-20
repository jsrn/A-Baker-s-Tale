package mobiles;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends Humanoid {

    BufferedImage playerN, playerE, playerS, playerW;

    public Player(int id, int x, int y) {
        super(id, x, y);
        try {
            playerN = ImageIO.read(new File("src/art/player_north1.png"));
            playerE = ImageIO.read(new File("src/art/player_east1.png"));
            playerS = ImageIO.read(new File("src/art/player_south1.png"));
            playerW = ImageIO.read(new File("src/art/player_west1.png"));
        } catch (Exception e) {
            System.out.println("Problem loading player art.");
        }
    }

    public BufferedImage getImage() {
        switch(getDirection()){
            case 1:
                return playerN;
            case 2:
                return playerE;
            case 3:
                return playerS;
            case 4:
                return playerW;
            default:
                return playerS;
        }
    }
        
}
