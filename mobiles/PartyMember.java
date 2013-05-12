package mobiles;

import abakerstale.Globals;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class PartyMember {
    
    private int hitPoints = 100;
    private int maxHitPoints = 100;
    private int manaPoints = 10;
    private int maxManaPoints = 10;
    private int experiencePoints = 0;
    private int level = 1;
    private String name = "PartyMember";
    private LinkedList<StatusEffect> statusEffects = new LinkedList();
    private BufferedImage face;
    private int portraitID = 1;
    
    public PartyMember(){
        
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }

    public int getHP() {
        return hitPoints;
    }

    public int getMaxHP() {
        return maxHitPoints;
    }
    
      public int getMP() {
        return manaPoints;
    }

    public int getMaxMP() {
        return maxManaPoints;
    }
    
    public int getLVL(){
        return level;
    }
    
    public void setPortraitID(int id){
        this.portraitID = id;
    }
    
    public BufferedImage getPortrait(){
        return Globals.TILEMAP.PORTRAITS.getSubimage((portraitID-1)*49, 0, 50, 50);
    }
    
}
