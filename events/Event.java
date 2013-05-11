package events;

import java.util.LinkedList;

public class Event {
    
    int x, y;
    private String triggerType;
    private LinkedList<String> messages = new LinkedList();
    
    public Event(){
        
    }
    
    public Event(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void addMessageEvent(String message){
        messages.add(message);
    }
    
    public LinkedList<String> getMessages(){
        return messages;
    }
    
    public String getTriggerType(){
        return triggerType;
    }
    
    public void setTriggerType(String t){
        triggerType = t;
    }
    
    public void trigger(){
        
        System.out.println("Triggering event!");
    }
    
}
