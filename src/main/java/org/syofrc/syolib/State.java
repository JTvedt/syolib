package org.syofrc.syolib;

public interface State<T> {
    public default State<T> consume(T object, State<T> state) {
        return state;
    }

    public default void enter(T object) {}
    public default void accept(T object) {} 
    public default void exit(T object) {}
}
