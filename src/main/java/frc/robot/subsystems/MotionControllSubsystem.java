package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class MotionControllSubsystem extends SubsystemBase {
    private WPI_TalonSRX MotorRightFront; //Right Front talon motor object
    private WPI_TalonSRX MotorLeftFront; //Left Front talon motor object
    private WPI_TalonSRX MotorRightRear; //Right Rear talon motor object
    private WPI_TalonSRX MotorLeftRear; //Left Rear talon motor object
    private SpeedControllerGroup Spg_Right , Spg_Left; // Controller Group objects
    private DifferentialDrive dff; // Differential Drive objectS
    

    public MotionControllSubsystem(){
        this.MotorRightFront = new WPI_TalonSRX(0/*port number (motor association)*/);
        this.MotorRightRear = new WPI_TalonSRX(1/*port number (motor association)*/);
        this.MotorLeftFront = new WPI_TalonSRX(2/*port number (motor association)*/);
        this.MotorLeftRear = new WPI_TalonSRX(3/*port number (motor association)*/);
        this.Spg_Left = new SpeedControllerGroup(MotorLeftFront, MotorLeftRear);
        this.Spg_Right = new SpeedControllerGroup(MotorRightFront, MotorRightRear);
        this.dff = new DifferentialDrive(Spg_Left, Spg_Right);


    }
    //tankDrive(double, double) - motion control by tank drive
    /**
     *         0-----0
     *  left-> |ⵙ(z)| <-right
     *         0-----0
     *        
     *        ^ x
     *        | 
     *       (ⵙ(z))-----> y
     *  
     *   the left double is the percentage output of the left motor controller group
     *   the right double is the percentage output of the right motor controller group
     * 
     *  */ 
    public void tankDrive (double Left , double Right){
     this.dff.tankDrive(Left, Right);   
    }
    //arcadeDrive(double, double) - motion control by arcade drive
    /**
     *          ^ speed
     *          |
     *         0-----0
     *  left-> |ⵙ(z)| <-right
     *         0-----0 )
     *        <----- rotate right
     *      
     *        ^ x
     *        |
     *        (ⵙ(z))-----> y
     *   the speed double is the percentage output of all motors (+/-) for foward/backward motion
     *   the rotation double controls the yaw motion of the robot (positive = rotate right around z axis, negative = rotate left around z axis)
     * 
     *  */ 
    public void arcadeDrive(double speed , double Rotation){
        this.dff.arcadeDrive(-speed, Rotation);
    }

}

