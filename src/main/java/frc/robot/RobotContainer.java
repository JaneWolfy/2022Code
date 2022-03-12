// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import java.sql.DriverManager;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDistance;
//import frc.robot.commands.Distance;
import frc.robot.commands.DriverControls;
import frc.robot.commands.Extend;
import frc.robot.commands.Lift;
import frc.robot.commands.Lower;
import frc.robot.commands.MagazineRun;
import frc.robot.commands.Retract;
import frc.robot.commands.Rotate;
import frc.robot.commands.Shoot;
import frc.robot.commands.Wheels;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.GrantsBaby;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //Subsytems 
  private final DriveBase driveBase = new DriveBase();
  private final Shooter shooter = new Shooter();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final Magazine magazine = new Magazine();
  private final GrantsBaby grantsBaby = new GrantsBaby();

  //Commands
  private final DriverControls driverControls = new DriverControls(driveBase);
  private final MagazineRun magazineRun = new MagazineRun(magazine);
  private final Rotate rotate = new Rotate(grantsBaby);
  private final Wheels intakeWheels = new Wheels(intake);

  //Joysticks
  public static Joystick driverRemote = new Joystick(Constants.DRIVER_REMOTE);
  public static Joystick mechRemote = new Joystick(Constants.MECH_REMOTE);

  //Buttons
  private JoystickButton mechA = new JoystickButton(mechRemote, Constants.A);
  private JoystickButton mechB = new JoystickButton(mechRemote, Constants.B);
  private JoystickButton mechY = new JoystickButton(mechRemote, Constants.Y);

  //Intake Buttons
  private JoystickButton mechL1 = new JoystickButton(mechRemote, Constants.L1);
  private JoystickButton mechR1 = new JoystickButton(mechRemote, Constants.R1);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   
    driveBase.setDefaultCommand(driverControls);
    magazine.setDefaultCommand(magazineRun);
    grantsBaby.setDefaultCommand(rotate);
    intake.setDefaultCommand(intakeWheels);
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  
  private void configureButtonBindings() {
    mechA.whenHeld(new Retract(climber));
    mechB.whenHeld(new Extend(climber));

    mechY.whenHeld(new Shoot(shooter));
    mechL1.whenHeld(new Lift(intake));
    mechR1.whenHeld(new Lower(intake));

    
     
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup(
      new AutoDistance(driveBase, -48, -10)
      );
  } 


}
