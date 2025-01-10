package org.syofrc.syolib.input;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ControllerFactory {
    public Controller XBoxController(CommandXboxController xboxController) {
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
