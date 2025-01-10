package org.syofrc.syolib.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.button.Trigger;

public class Controller {
    private final Map<String, Trigger> triggerMap = new HashMap<>();
    private final Map<String, Supplier<Double>> axisMap = new HashMap<>();

    public class Builder {
        private final Controller controller = new Controller();

        public void bindTrigger(String key, Trigger trigger) {
            controller.triggerMap.put(key, trigger);
        }
        
        public void bindAxis(String key, Supplier<Double> axis) {
            controller.axisMap.put(key, axis);
        }

        public Controller build() {
            return controller;
        }
    }
}
