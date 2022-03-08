package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;
import frc.robot.subsystems.ClimbingSubSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PullOutCommand extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getClimbingSubSystem());
    }
    @Override
    public void execute() {
        m_robotContainer.getClimbingSubSystem().expand(-0.65);
        if(!m_robotContainer.getClimbingSubSystem().getSwitch())
        {
            end(true);
        }
    }
    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getClimbingSubSystem().stop();
    }
}
