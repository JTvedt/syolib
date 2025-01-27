package org.syofrc.syolib.state;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * Class that captures a particular state
 */
public interface State {
    public Command getCommand();
    public Command transitionTo(State state);
}
