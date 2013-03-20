package mobiles;

import abakerstale.Constants;
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
    int STEP3_OFFSET = 52;
    int STEP4_OFFSET = 78;

    public Player(int id, int x, int y) {
        super(id, x, y);
        try {
            playerSprites = ImageIO.read(new File("src/art/sprites_player.png"));
        } catch (Exception e) {
            System.out.println("Problem loading player art.");
        }
    }

    public BufferedImage getImage() {
        return playerSprites.getSubimage(getStepOffset(), getDirectionOffset(), 25, 25);
    }

    private int getDirectionOffset() {
        int offset = SOUTH_ROWHEIGHT;

        switch (getDirection()) {
            case Constants.DIRECTION_NORTH:
                offset = NORTH_ROWHEIGHT;
            case Constants.DIRECTION_EAST:
                return EAST_ROWHEIGHT;
            case Constants.DIRECTION_SOUTH:
                return SOUTH_ROWHEIGHT;
            case Constants.DIRECTION_WEST:
                return WEST_ROWHEIGHT;
        }

        return offset;
    }

    private int getStepOffset() {
        int offset = STEP1_OFFSET;

        switch (getStep()) {
            case 1:
                offset = STEP1_OFFSET;
                break;
            case 2:
                offset = STEP2_OFFSET;
                break;
            case 3:
                offset = STEP3_OFFSET;
                break;
            case 4:
                offset = STEP4_OFFSET;
                break;
        }

        return offset;
    }
}
