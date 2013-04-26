package gui;

public class TextBox {
    
    private int x, y, w, h;
    private String text;
    
    public TextBox(String s){
        text = s;
        x = 0;
        y = 0;
        w = 600;
        h = 100;
    }
    
    public TextBox(String s, int x, int y, int w, int h){
        text = s;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getHeight() {
        return h;
    }

    public String getText() {
        return text;
    }

    public int getWidth() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
