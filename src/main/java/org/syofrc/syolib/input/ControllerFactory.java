package org.syofrc.syolib.input;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * <p>Factory for creating {@link Controller} objects from Command variants of WPILib HID Controllers</p>
 * <p>Currently Supports:</p>
 * <ul>
 *   <li>{@link CommandXboxController}
 * </ul>
 */
public class ControllerFactory {
    /**
     * Creates {@link Controller} object from an XboxController
     * @param xboxController Command-Based XBox Controller to map bindings
     * @return Bound controller
     */
    public Controller makeController(CommandXboxController xboxController) {
        return new Controller.Builder(Controller.Type.GAMEPAD)
            .bindTrigger("a", xboxController.a())
            .bindTrigger("b", xboxController.b())
            .bindTrigger("x", xboxController.x())
            .bindTrigger("y", xboxController.y())
            .bindTrigger("lt", xboxController.leftTrigger())
            .bindTrigger("rt", xboxController.rightTrigger())
            .bindTrigger("lb", xboxController.leftBumper())
            .bindTrigger("rb", xboxController.rightBumper())
            .bindTrigger("left-trigger", xboxController.leftTrigger())
            .bindTrigger("right-trigger", xboxController.rightTrigger())
            .bindTrigger("left-bumper", xboxController.leftBumper())
            .bindTrigger("right-bumper", xboxController.rightBumper())
            .bindAxis("lx", (() -> xboxController.getLeftX()))
            .bindAxis("ly", (() -> xboxController.getLeftY()))
            .bindAxis("rx", (() -> xboxController.getRightX()))
            .bindAxis("ry", (() -> xboxController.getRightY()))
            .bindAxis("left-x", (() -> xboxController.getLeftX()))
            .bindAxis("left-y", (() -> xboxController.getLeftY()))
            .bindAxis("right-x", (() -> xboxController.getRightX()))
            .bindAxis("right-y", (() -> xboxController.getRightY()))
            .bindAxis("left-stick-x", (() -> xboxController.getLeftX()))
            .bindAxis("left-stick-y", (() -> xboxController.getLeftY()))
            .bindAxis("right-stick-x", (() -> xboxController.getRightX()))
            .bindAxis("right-stick-y", (() -> xboxController.getRightY()))
            .bindAxis("lt", (() -> xboxController.getLeftTriggerAxis()))
            .bindAxis("rt", (() -> xboxController.getRightTriggerAxis()))
            .bindAxis("left-trigger", (() -> xboxController.getLeftTriggerAxis()))
            .bindAxis("right-trigger", (() -> xboxController.getRightTriggerAxis()))
            .build();
    }
}
