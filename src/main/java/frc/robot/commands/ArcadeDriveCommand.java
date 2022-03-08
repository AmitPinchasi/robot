package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDriveCommand extends CommandBase{
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getDriverSubsystem());
        m_robotContainer.getDriverSubsystem().feed();
    }
    @Override
    public void execute() {
        m_robotContainer.getDriverSubsystem().feed();
        m_robotContainer.getDriverSubsystem().ArcadeDrive((m_robotContainer.getStick().getY()/1.2)*0.9, (m_robotContainer.getStick().getX()/1.2)*0.9);
    }
    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getDriverSubsystem().feed();
        m_robotContainer.getDriverSubsystem().StopDrive();
    }
}