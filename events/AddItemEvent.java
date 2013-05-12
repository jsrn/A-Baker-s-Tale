package events;

import abakerstale.Globals;

public class AddItemEvent extends Event {
    String item;
    int quantity;
    
    public AddItemEvent(String i, int q){
        item = i;
        quantity = q;
    }
    
    public void trigger(){
        Globals.PLAYER.giveItem(item);
    }
    
}
