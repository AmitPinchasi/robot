package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class pullCommand extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getClimbingSubSystem());
    }
    @Override
    public void execute() {
        m_robotContainer.getClimbingSubSystem().pull(0.4);
    }
    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getClimbingSubSystem().stop();
    }
}
