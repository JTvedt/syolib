package org.syofrc.syolib.input;

/**
 * Pattern which denotes a particular controller and input for a controller
 */
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
