package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;

public class ShootingSubsystem extends SubsystemBase{
    private WPI_TalonSRX shootingMotor;
    public Servo servo;

    public ShootingSubsystem(){
        this.shootingMotor = new WPI_TalonSRX(Constants.Shoot.ShootMotor);
        servo = new Servo(9);
    }
    public void shoot(double power){
        this.shootingMotor.set(ControlMode.PercentOutput, power);
    }
    public void open(){
        this.servo.setAngle(150);
    }

    public void stop(){
        this.shootingMotor.set(ControlMode.PercentOutput,0);
        this.servo.setAngle(360);
    }
}
