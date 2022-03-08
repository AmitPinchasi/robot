// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ClimbingCommand;
import frc.robot.commands.CollectorCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ShootingCommand;
import frc.robot.subsystems.ClimbingSubSystem;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.DriverSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShootingSubsystem;
import frc.robot.commands.pullCommand;
import frc.robot.commands.PullOutCommand;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  
  private final ShootingSubsystem shootingSubsystem =  new ShootingSubsystem();
  private ShootingCommand shootingCommand;
  
  private final CollectorSubsystem collectorSubsystem = new CollectorSubsystem();
  private CollectorCommand collectorCommand;
  
  private final ClimbingSubSystem climbingSubSystem =new ClimbingSubSystem();
  private ClimbingCommand climbingCommand;
  // private final ControllerDriveSubsystem controllerDriveSubsystem = new ControllerDriveSubsystem();
  // private DriverControllerCommand driverControllerCommand;

  private final DriverSubsystem driverSubsystem = new DriverSubsystem();
  private ArcadeDriveCommand arcadeDriveCommand;

  private AutonomousCommand autonomousCommand;

  private PullOutCommand pullOutCommand;

  private pullCommand pull;

  private Joystick tankStick1,tankStick2,CommandStick;
  public JoystickButton CommandStickButtons[] = new JoystickButton[12];
  private XboxController controller;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    this.shootingCommand = new ShootingCommand();
    
    this.autonomousCommand = new AutonomousCommand();
    this.climbingCommand = new ClimbingCommand();
    this.pull = new pullCommand();
    this.collectorCommand = new CollectorCommand();
    this.pullOutCommand = new PullOutCommand();
    //this.driverControllerCommand = new DriverControllerCommand();
  }//FRCTRP4661
  public void teleopPeriodic(){//this is not the teleopPeriodic its a function that the L O R D made
    this.driverSubsystem.ArcadeDrive(tankStick2.getY(), tankStick2.getX());
    this.driverSubsystem.feed();
  }
  public void autonomousTest(long startTime){
    long time = System.currentTimeMillis() - startTime;
    //רובוט יורה1   כדורים
    if(time <= 3000) {this.getShootingCommand();}
    //רובוט עושה סיבןב שך 180 מעלות
    else if(time <= 6000 && time - startTime > 3000){this.getDriverSubsystem().TankDrive(0.5, -0.5);} 
    //נוסע קדימה הפרש מרחקים
    else if(time > 6000 && time <= 7000) {this.getDriverSubsystem().TankDrive(0.5, 0.5);}
    //עוצר פלוס טיפה אחורה
    else if(time >= 7000 && time <= 8000){this.getDriverSubsystem().TankDrive(-0.5, -0.5);}
    // רובוט אוסף כדורים
    else if(time > 8000 && time <= 9000) {this.getCollectorCommand(); this.getCollectorCommand();} 
    //רוסוט עושה סיבוב של 180 מעלות
    else if(time > 9000 && time <= 10000) {this.getDriverSubsystem().TankDrive(0.5, -0.5);}
    //רובוט נוסה קדימה הפרש מרחקים
    else if(time > 10000 && time <= 11000) {this.getDriverSubsystem().TankDrive(0.5, 0.5);}
    // רובוט יורה כדוד אחד
    else if(time > 11000 && time <= 1400) {this.getShootingCommand();}
  }
  public ShootingSubsystem getShootingSubsytem(){
    return this.shootingSubsystem;
  }
  public Command getShootingCommand(){
    return this.shootingCommand;
  }
  public Joystick getStick(){
    return this.tankStick1;
  }

  public DriverSubsystem getDriverSubsystem(){
    return this.driverSubsystem;
  } 
  public ClimbingSubSystem getClimbingSubSystem(){
    return this.climbingSubSystem;
  }
  public CollectorSubsystem getCollectorSubsystem(){
    return this.collectorSubsystem;
  }
  public Joystick getTankStick(){
    return this.tankStick2;
  }
  public Command getArcadeDriveCommand(){
    return this.arcadeDriveCommand;
  }
  public Command getCollectorCommand(){
    return this.collectorCommand;
  }
  public Command getAutonomousesCommand(){
    return this.autonomousCommand;
  }
  public Command getclimbingCommand(){
    return this.climbingCommand;
  }
  public Command getPullCommand(){
    return this.pull;
  }
  public XboxController getController(){
    return this.controller;
  }
  public Command getPullOutCommand(){
    return this.pullOutCommand;
  }
  // public Command getDriverControllerCommand(){
  //   return this.driverControllerCommand;
  // }



  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    this.tankStick1 = new Joystick(1);
    this.CommandStick = new Joystick(0);
    this.tankStick2 = new Joystick(2);
    //this.controller = new XboxController(0);
    for(int i = 0; i < CommandStickButtons.length; i++){
      CommandStickButtons[i] = new JoystickButton(this.CommandStick, i);
    }
    
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
