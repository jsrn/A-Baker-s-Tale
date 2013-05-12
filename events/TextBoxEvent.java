package events;

import abakerstale.Globals;

public class TextBoxEvent extends Event {
    
    private String text;
    
    public TextBoxEvent(String text){
        this.text = text;
    }
    
    public void trigger(){
        Globals.stateMachine.AddTextBox(text);
    }
    
}
