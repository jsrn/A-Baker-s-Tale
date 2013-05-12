package mobiles;

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
    
    public PartyMember(){
        
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
}
