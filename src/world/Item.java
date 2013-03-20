package world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Item {
    
    BufferedImage image;
    private int x, y, passable;
    private String tile;
    
    public Item(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage getImage(){
        try {
            BufferedImage image = ImageIO.read(new File("src/art/" + tile + ".png"));
            return image;
        } catch (IOException ex) {
            System.out.println("Failed loading image.");
        }
        return null;
    }
    
    public String getTileName(){
        return tile;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean isPassable(){
        return passable == 1;
    }
    
    public String toString(){
        return "[" + x + "," + y + "] " + tile;
    }
    
}
