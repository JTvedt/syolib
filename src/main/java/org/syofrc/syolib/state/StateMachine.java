package org.syofrc.syolib.state;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Finite State Machine (FSM) that operates on a particular type of object
 */
public class StateMachine extends SubsystemBase {
    private final Subsystem subsystem;
    private State currentState;
    private State desiredState;

    public StateMachine(Subsystem subsystem) {
        this.subsystem = subsystem;
    }

    @Override
    public void periodic() {
        if (currentState != desiredState) {
            Command transition = currentState.transitionTo(desiredState);
            if (transition != null) {
                currentState = desiredState;
                CommandScheduler.getInstance().schedule(Commands.sequence(transition, desiredState.getCommand()));
                subsystem.setDefaultCommand(currentState.getCommand());
            }
        }
    }

    public void setDesiredState(State desiredState) {
        this.desiredState = desiredState;
    }
}