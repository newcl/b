package info.chenliang.b;

import info.chenliang.b.generated.message.State;

public interface StatesListener {
    void stateCreated(State state);
    void stateUpdated(State state);
}
