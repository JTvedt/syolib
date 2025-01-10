package org.syofrc.syolib.input;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotNull;

public class InputSystem {
    private final Map<Integer, Controller> controllerMap = new HashMap<>();
    private final Map<String, ControllerPattern> triggerMap = new HashMap<>();
    private final Map<String, ControllerPattern> axisMap = new HashMap<>();

    public static class Builder {
        private final InputSystem inputSystem = new InputSystem();

        public Builder bindController(Controller controller, int id) {
            inputSystem.controllerMap.put(id, controller);
            return this;
        }

        public InputSystem build() {
            return inputSystem;
        }
    }
}
