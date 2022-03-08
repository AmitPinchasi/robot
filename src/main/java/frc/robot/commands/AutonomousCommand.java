package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Robot.m_robotContainer;

public class AutonomousCommand extends CommandBase {
    private long startTime;
    @Override
    public void initialize(){
        this.startTime = System.currentTimeMillis();
        m_robotContainer.getDriverSubsystem().feed();
        addRequirements(m_robotContainer.getDriverSubsystem(),m_robotContainer.getShootingSubsytem());
    }
    @Override
    public void execute(){
        if((System.currentTimeMillis() - this.startTime) <= 1000)
        {
            m_robotContainer.getDriverSubsystem().feed();
            m_robotContainer.getDriverSubsystem().TankDrive(0.5, 0.5);
        } 
        else if(System.currentTimeMillis() - this.startTime > 1000 && System.currentTimeMillis()-this.startTime <= 2500)
        {
            m_robotContainer.getShootingSubsytem().shoot(0.5);
        }
        else
        {
            m_robotContainer.getDriverSubsystem().feed();
            this.startTime = System.currentTimeMillis();
            end(true);
        }
    }
    @Override
    public void end(boolean interrupted)
    {
        System.out.println("I Died!");
    }
}
