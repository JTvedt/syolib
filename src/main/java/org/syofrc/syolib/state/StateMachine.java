package org.syofrc.syolib.state;

/**
 * Finite State Machine (FSM) that operates on a particular type of object
 * @param <T> The type of object the FSM is compatible with
 */
public class StateMachine<T> {
    private State<T> wantedState;
    private State<T> currentState;

    /**
     * Sets the desired state for the state machine to accept transition to
     * @param state Desired state for the FSM
     */
    public void setWanted(State<T> state) { wantedState = state; }
    
    /**
     * Process the current state using the provided object
     * @param object Object for the FSM to work on
     */
    public void accept(T object) {
        if (currentState != wantedState) {
            State<T> previousState = currentState;
            currentState = currentState.consume(object, wantedState);

            if (previousState != currentState) {
                previousState.exit(object);
                currentState.enter(object);
            }
        }
        currentState.accept(object);
    }
}