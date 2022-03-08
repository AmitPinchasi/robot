package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriverSubsystem extends SubsystemBase {
    private WPI_TalonSRX MotorRightFront , MotorRightRear;
    private SpeedControllerGroup SPD_Right;
    private WPI_TalonSRX MotorLeftFront , MotorLeftRear;
    private SpeedControllerGroup SPD_Left;
    private DifferentialDrive diff;

    public DriverSubsystem(){
        this.MotorRightFront =new WPI_TalonSRX(Constants.Drive.Right_Front_Motor);
        this.MotorRightRear = new WPI_TalonSRX(Constants.Drive.Right_Rear_Motor);
        this.SPD_Right = new SpeedControllerGroup(this.MotorRightFront, this.MotorRightRear);
        this.MotorLeftFront = new WPI_TalonSRX(Constants.Drive.Left_Front_Motor);
        this.MotorLeftRear = new WPI_TalonSRX(Constants.Drive.Left_Rear_Motor);
        this.SPD_Left = new SpeedControllerGroup(this.MotorLeftFront, this.MotorLeftRear);
        this.diff = new DifferentialDrive(this.SPD_Left, this.SPD_Right);

        
    }
    public void feed(){
        this.diff.feedWatchdog();
    }
    public void ArcadeDrive(double stickY, double stickX){
        this.diff.arcadeDrive(-stickY, stickX, true);
    }
    public void TankDrive(double stick1, double stick2){
        this.diff.tankDrive(stick1*0.9, stick2*0.9, true);
    }
    public void spin(double power){
        this.diff.tankDrive(power, -power, true);
    }
    public void StopDrive(){
        this.diff.arcadeDrive(0, 0, true);
    }
    public void GoForward(double speed) {
        this.diff.tankDrive(speed, speed, true);
    }
}
