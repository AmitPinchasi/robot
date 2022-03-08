package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbingSubSystem extends SubsystemBase {
    public WPI_TalonSRX pull_motor ; 
    public WPI_TalonSRX expend_motor;
    private DigitalInput the_limit_switch;

    public ClimbingSubSystem(){
        expend_motor = new WPI_TalonSRX(Constants.Climb.ClimbMotor);
        pull_motor = new WPI_TalonSRX(Constants.Climb.PullMotor/*port number [can change]*/);
        this.the_limit_switch =new DigitalInput(3/*the channel of the switch*/);
    }
    
    //the expand funcation cause the robot to open his climbing arm 
    public void expand(double speed){
        
        expend_motor.set(ControlMode.PercentOutput,speed);
    }
    public boolean getSwitch(){
        return this.the_limit_switch.get();
    }
    public void pull(double speed){
        pull_motor.set(ControlMode.PercentOutput , speed);
    }
    public void stop(){
        expend_motor.set(ControlMode.PercentOutput, 0);
        pull_motor.set(ControlMode.PercentOutput, 0);
    }
}
