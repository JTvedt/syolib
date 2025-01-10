package org.syofrc.syolib;

public class StateMachine<T> {
    private State<T> wantedState;
    private State<T> currentState;

    public void setWanted(State<T> state) { wantedState = state; }
    
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