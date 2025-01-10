package org.syofrc.syolib.input;

public class ControllerPattern {
    public final Controller.Type controllerType;
    public final String key;
    public final int controllerId;

    public ControllerPattern(Controller.Type type, String key, int id) {
        this.controllerType = type;
        this.key = key;
        this.controllerId = id;
    }
}
