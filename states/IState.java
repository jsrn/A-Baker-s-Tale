package states;

import gui.TextBox;

public interface IState {
    
    public abstract void Update(float elapsedTime);
    
    public abstract void Render();
    
    public abstract void Keypress(int keycode);
    
    public abstract void OnEnter();
    
    public abstract void OnExit();
    
    public abstract void AddTextBox(TextBox t);
    
    public abstract void RemoveTextBox(TextBox t);
    
}
