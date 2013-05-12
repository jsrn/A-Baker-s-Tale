package states;

import abakerstale.Globals;
import abakerstale.Keys;
import gui.TextBox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MainMenuState implements IState {
    
    private int selectedIndex = 1;
    
    public void Update(float elapsedTime) {
    }

    public void Render() {
        BufferedImage frame = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics frameGraphics = frame.getGraphics();
        
        frameGraphics.drawImage(Globals.TILEMAP.MAINMENU, 0, 0, null);
        
        frameGraphics.setColor(Color.WHITE);
        switch(selectedIndex){
            case 1:
                underlineLeft(frameGraphics);
                break;
            case 2:
                underlineRight(frameGraphics);
                break;
        }
   
        Globals.gamePanel.getGraphics().drawImage(frame, 0, 0, null);
    }

    public void OnEnter() {
    }

    public void OnExit() {
    }

    public void Keypress(int keycode) {
        switch(keycode){
            case Keys.LEFT:
                moveSelectionLeft();
                Globals.pressedKeys[Keys.LEFT] = false;
                break;
            case Keys.RIGHT:
                moveSelectionRight();
                Globals.pressedKeys[Keys.RIGHT] = false;
                break;
            case Keys.ENTER:
                switch(selectedIndex){
                    case 1:
                        Globals.stateMachine.Change("localmap");
                        break;
                    case 2:
                        System.err.println("Loading not yet implemented.");
                        System.exit(1);
                        break;
                }  
        }
    }
    
    private void moveSelectionLeft(){
        if(selectedIndex == 2){
            selectedIndex = 1;
        } else {
            selectedIndex = 2;
        }
    }
    
    private void moveSelectionRight(){
        if(selectedIndex == 1){
            selectedIndex = 2;
        } else {
            selectedIndex = 1;
        }
    }
    
    private void underlineLeft(Graphics g){
        g.drawLine(115, 255, 170, 255);
        g.drawLine(120, 258, 165, 258);
        g.drawLine(125, 261, 160, 261);
    }
    
    private void underlineRight(Graphics g){
        g.drawLine(315, 255, 405, 255);
        g.drawLine(320, 258, 400, 258);
        g.drawLine(325, 261, 395, 261);
    }

    public void AddTextBox(TextBox t) {
    }

    public void RemoveTextBox(TextBox t) {
    }
    
}
