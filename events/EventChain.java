package events;

import java.util.Iterator;
import java.util.LinkedList;

public class EventChain {

    LinkedList<Event> eventChain = new LinkedList();
    private int x, y;
    private String triggerType;

    public EventChain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addEvent(Event e) {
        eventChain.add(e);
    }

    public void run() {
        for (Iterator<Event> it = eventChain.iterator(); it.hasNext();) {
            Event event = it.next();
            event.preDelay();
            event.trigger();
            event.postDelay();
        }
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String t) {
        triggerType = t;
    }
}
