package mobiles;

import abakerstale.Constants;
import abakerstale.Globals;
import abakerstale.Keys;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import world.Cell;

public class Player extends Mobile {
    
    private LinkedList<String> inventory = new LinkedList();

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
                break;
            case Constants.DIRECTION_EAST:
                offset = EAST_ROWHEIGHT;
                break;
            case Constants.DIRECTION_SOUTH:
                offset = SOUTH_ROWHEIGHT;
                break;
            case Constants.DIRECTION_WEST:
                offset = WEST_ROWHEIGHT;
                break;
        }

        return offset;
    }

    private int getStepOffset() {
        int offset = Globals.frameCount;

        boolean down = Globals.pressedKeys[Keys.DOWN];
        boolean left = Globals.pressedKeys[Keys.LEFT];
        boolean right = Globals.pressedKeys[Keys.RIGHT];
        boolean up = Globals.pressedKeys[Keys.UP];
        
        if (!down && !left && !right && !up) {
            offset = STEP1_OFFSET;
        } else if (offset > 0 && offset <= 15) {
            offset = STEP1_OFFSET;
        } else if (offset > 15 && offset <= 30) {
            offset = STEP2_OFFSET;
        } else if (offset > 30 && offset <= 45) {
            offset = STEP3_OFFSET;
        } else {
            offset = STEP4_OFFSET;
        }
        return offset;
    }

    public LinkedList<String> getInventory() {
        return inventory;
    }

    public void giveItem(String string) {
        inventory.add(string);
    }
 
}
