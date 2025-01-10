package org.syofrc.syolib.state;

/**
 * Class that captures a particular state for a particular object
 * 
 * @param <T> Type of the object that uses this state and that this state can operate on
 */
public interface State<T> {
    /**
     * Receives a particular state and processes state transitions from there
     * 
     * @param object Object the state works on
     * @param state State to attempt transition to
     * @return Outcome of attempted state transition
     */
    public default State<T> consume(T object, State<T> state) {
        return state;
    }

    /**
     * Handles state initialization/processes on entering the state from transition
     * @param object Object the state works on
     */
    public default void enter(T object) {}
    
    /**
     * Regular process defined by the state
     * @param object Object the state works on
     */
    public default void accept(T object) {}
    
    /**
     * Handles transition out of the state
     * @param object Object the state works on
     */
    public default void exit(T object) {}
}
