package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CollectorSubsystem extends SubsystemBase {
    private WPI_TalonSRX theOpener;
    public CollectorSubsystem(){
        this.theOpener = new WPI_TalonSRX(Constants.collect.CollectMotor);
        
    }
    public void Collect(double power){
            this.theOpener.set(ControlMode.PercentOutput , power);
    }
    public void stop(){
        this.theOpener.set(ControlMode.PercentOutput, 0);
    }
}