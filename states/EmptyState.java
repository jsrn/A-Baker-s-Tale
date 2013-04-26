package states;

import gui.TextBox;

public class EmptyState implements IState{

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
