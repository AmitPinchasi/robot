package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimbingCommand extends CommandBase {
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getClimbingSubSystem());
    }

    @Override
    public void execute() {
        m_robotContainer.getClimbingSubSystem().expand(0.7);
    }
    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getClimbingSubSystem().stop();;

    }
}
