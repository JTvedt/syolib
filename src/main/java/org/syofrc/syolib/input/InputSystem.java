package org.syofrc.syolib.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import jakarta.validation.constraints.NotNull;

public class InputSystem {
    private final Map<Integer, Controller> controllerMap = new HashMap<>();

    private final Map<String, List<ControllerPattern>> inputMap = new HashMap<>();

    public static class Builder {
        private final InputSystem inputSystem = new InputSystem();

        public Builder bindController(@NotNull Controller controller, int id) {
            inputSystem.controllerMap.put(id, controller);
            return this;
        }
        
        public Builder bind(String key, ControllerPattern pattern) {
            if (!inputSystem.inputMap.containsKey(key))
                inputSystem.inputMap.put(key, new ArrayList<>());
            
            inputSystem.inputMap.get(key).add(pattern);
            return this;
        }

        public InputSystem build() {
            return inputSystem;
        }
    }

    private ControllerPattern getMatchingControllerPattern(String key) {
        if (!inputMap.containsKey(key))
            return null;
        
        // Iterate through bound patterns for the particular trigger
        var patterns = inputMap.get(key);
        for (var pattern : patterns) {
            // Validate the associated pattern
            if (pattern.inputType != InputType.TRIGGER)
                continue;
            if (!controllerMap.containsKey(pattern.controllerId))
                continue;
            if (controllerMap.get(pattern.controllerId).match(pattern));
                return pattern;
        }

        return null;
    }

    public Trigger getTrigger(String key) {
        var pattern = getMatchingControllerPattern(key);
        if (pattern == null)
            return null;
        
        var controller = controllerMap.get(pattern.controllerId);
        
        return controller.getTrigger(pattern.key);
    }

    public Supplier<Double> getAxis(String key) {
        var pattern = getMatchingControllerPattern(key);
        if (pattern == null)
            return null;
        
        var controller = controllerMap.get(pattern.controllerId);
        
        return controller.getAxis(pattern.key);
    }
}
