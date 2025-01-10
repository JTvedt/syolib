package org.syofrc.syolib.input;

public class ControllerPattern {
    public final InputType inputType;
    public final Controller.Type controllerType;
    public final String key;
    public final int controllerId;

    public ControllerPattern(InputType inputType, Controller.Type controllerType, String key, int id) {
        this.inputType = inputType;
        this.controllerType = controllerType;
        this.key = key;
        this.controllerId = id;
    }
}
