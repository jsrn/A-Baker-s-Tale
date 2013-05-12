package states;

import gui.TextBox;
import java.awt.Color;

public class MainMenuState implements IState {
    
    public Color GUI_BACKGROUND = new Color(0, 0, 255, 180);
    public Color GUI_BORDER = new Color(255, 255, 255);
    public Color GUI_TEXT = new Color(255, 255, 255);

    public void Update(float elapsedTime) {
    }

    public void Render() {
    }

    public void OnEnter() {
    }

    public void OnExit() {
    }

    public void Keypress(int keycode) {
    }

    public void AddTextBox(TextBox t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void RemoveTextBox(TextBox t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}