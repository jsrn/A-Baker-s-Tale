package events;

public class Event {

    private int preDelay = 0;
    private int postDelay = 0;

    public Event() {
    }

    public void trigger() {
        System.err.println("This method should only be called from the overiding class.");
    }
    
    public void setPreDelay(int d){
        preDelay = d;
    }
    
    public void setPostDelay(int d){
        postDelay = d;
    }

    public void preDelay() {
        try {
            Thread.sleep(preDelay);
        } catch (InterruptedException ex) {
            System.err.println("Error in preDelay wait.");
        }
    }

    public void postDelay() {
        try {
            Thread.sleep(postDelay);
        } catch (InterruptedException ex) {
            System.err.println("Error in postDelay wait.");
        }
    }
}
