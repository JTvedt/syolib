package org.syofrc.syolib.input;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Controller {
    private final Type type;
    private final Map<String, Trigger> triggerMap = new HashMap<>();
    private final Map<String, Supplier<Double>> axisMap = new HashMap<>();

    public Controller(Type type) {
        this.type = type;
    }

    public static class Builder {
        private final Controller controller;

        Builder(Type type) {
            controller = new Controller(type);
        }

        public Builder bindTrigger(String key, Trigger trigger) {
            controller.triggerMap.put(key, trigger);
            return this;
        }
        
        public Builder bindAxis(String key, Supplier<Double> axis) {
            controller.axisMap.put(key, axis);
            return this;
        }

        public Controller build() {
            return controller;
        }
    }

    public static enum Type {
        GAMEPAD,
        JOYSTICK,
        KEYBOARD,
    }

    public Type getType() {
        return type;
    }

    public Trigger getTrigger(String key) {
        return triggerMap.get(key);
    }

    public Supplier<Double> getAxis(String key) {
        return axisMap.get(key);
    }

    public boolean match(ControllerPattern pattern) {
        if (pattern.controllerType != type)
            return false;
        
        return switch (pattern.inputType) {
            case TRIGGER -> triggerMap.containsKey(pattern.key);
            case AXIS -> axisMap.containsKey(pattern.key);
        };
    }
}
