package mobiles;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Player extends Humanoid {

    BufferedImage playerSprites;

    int SOUTH_ROWHEIGHT = 0;
    int EAST_ROWHEIGHT = 26;
    int NORTH_ROWHEIGHT = 52;
    int WEST_ROWHEIGHT = 78;
    
    int STEP1_OFFSET = 0;
    int STEP2_OFFSET = 26;

    public Player(int id, int x, int y) {
        super(id, x, y);
        try {
            playerSprites = ImageIO.read(new File("src/art/sprites_player.png"));
        } catch (Exception e) {
            System.out.println("Problem loading player art.");
        }
    }

    public BufferedImage getImage() {
        switch(getDirection()){
            case 1:
                return playerSprites.getSubimage(STEP1_OFFSET, NORTH_ROWHEIGHT, 25, 25);
            case 2:
                return playerSprites.getSubimage(STEP1_OFFSET, EAST_ROWHEIGHT, 25, 25);
            case 3:
                return playerSprites.getSubimage(STEP1_OFFSET, SOUTH_ROWHEIGHT, 25, 25);
            case 4:
                return playerSprites.getSubimage(STEP1_OFFSET, WEST_ROWHEIGHT, 25, 25);
            default:
                return playerSprites.getSubimage(STEP1_OFFSET, SOUTH_ROWHEIGHT, 25, 25);
        }
    }
        
}
