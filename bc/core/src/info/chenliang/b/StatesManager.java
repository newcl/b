package info.chenliang.b;

import info.chenliang.b.generated.message.State;
import info.chenliang.b.generated.message.States;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


public class StatesManager {
    private Map<String, State> current = new HashMap<>();

    @Autowired
    StatesListener statesListener;

    public void onStates(States states) {
        states.getStatesList().forEach(state -> {
            if (current.containsKey(state.getId())) {
                statesListener.stateUpdated(state);
            } else {
                statesListener.stateCreated(state);
            }
            current.put(state.getId(), state);
        });
    }
}
