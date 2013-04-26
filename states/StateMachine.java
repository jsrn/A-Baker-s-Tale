package states;

import java.util.HashMap;
import java.util.Map;

public class StateMachine {
    Map<String, IState> mStates = new HashMap<String, IState>();
    IState mCurrentState = null;
 
    public void Update(float elapsedTime)
    {
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
 
    public void Add(String name, IState state){
        mStates.put(name, state);
    }
}