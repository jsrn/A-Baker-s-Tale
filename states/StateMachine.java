package states;

import abakerstale.Globals;
import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    Map<String, IState> mStates = new HashMap<String, IState>();
    IState mCurrentState = new EmptyState();
 
    public void Update(float elapsedTime)
    {
        Keypress();
        mCurrentState.Update(elapsedTime);
    }
 
    public void Render()
    {
        mCurrentState.Render();
    }
 
    public void Change(String stateName){
        mCurrentState.OnExit();
        mCurrentState = mStates.get(stateName);
        mCurrentState.OnEnter();
    }
    
    public void Keypress(){
        for (int i = 0; i < Globals.pressedKeys.length; i++) {
            if (Globals.pressedKeys[i] == true) {
                mCurrentState.Keypress(i);
            }
        }
    }
 
    public void Add(String name, IState state){
        mStates.put(name, state);
    }
}