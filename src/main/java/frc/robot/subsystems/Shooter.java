// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogInput;

public class Shooter extends SubsystemBase {

  private TalonFX shooter1, shooter2;
  public AnalogInput analog;
  NetworkTableEntry ty;

  /** Creates a new Shooter. */
  public Shooter() {
    shooter1 = new TalonFX(Constants.SHOOTER_1);

    /*shooter1.configFactoryDefault();
    shooter1.configNeutralDeadband(0.001);
    shooter1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0,30);

    shooter1.configNominalOutputForward(0, 30);
    shooter1.configNominalOutputReverse(0,30);
    shooter1.configPeakOutputForward(1, 30);
    shooter1.configPeakOutputReverse(-1, 30);

    shooter1.config_kF(0, 1023.0/20660.0,30);
    shooter1.config_kP(0, 0.1,30);
    shooter1.config_kI(0,0.001,30);
    shooter1.config_kD(0, 5,30);*/



    shooter2 = new TalonFX(Constants.SHOOTER_2);

    /*shooter2.configFactoryDefault();
    shooter2.configNeutralDeadband(0.001);
    shooter2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0,30);

    shooter2.configNominalOutputForward(0, 30);
    shooter2.configNominalOutputReverse(0,30);
    shooter2.configPeakOutputForward(1, 30);
    shooter2.configPeakOutputReverse(-1, 30);

    shooter2.config_kF(0, 1023.0/20660.0,30);
    shooter2.config_kP(0, 0.1,30);
    shooter2.config_kI(0,0.001,30);
    shooter2.config_kD(0, 5,30);

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    ty = table.getEntry("ty");*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(){
    //double targetVelocity_UnitsPer100ms =  1234.5 *2048.0/600.0;
    //shooter1.set(TalonFXControlMode.Velocity, targetVelocity_UnitsPer100ms);
    //shooter2.set(TalonFXControlMode.Velocity, targetVelocity_UnitsPer100ms);
    shooter1.set(ControlMode.PercentOutput, 1);
    shooter2.set(ControlMode.PercentOutput, 1);
  } 

  public void shootStop(){
    //double targetVelocity_UnitsPer100ms =  1234.5 *2048.0/600.0;
    //shooter1.set(TalonFXControlMode.Velocity, targetVelocity_UnitsPer100ms);
    //shooter2.set(TalonFXControlMode.Velocity, targetVelocity_UnitsPer100ms);
    shooter1.set(ControlMode.PercentOutput, 0);
    shooter2.set(ControlMode.PercentOutput, 0);
  } 


  public void distance(){
      /*double heightDiffrence = Constants.TARGET_HEIGHT - Constants.CAMERA_HEIGHT;
      double yAngle = ty.getDouble(0.0);
      double tangent = Math.tan(Math.toRadians(Constants.LIMELIGHT_ANGLE) +  Math.toRadians(yAngle));
      double distance = heightDiffrence / tangent ;
      System.out.println(((1.12 * distance) - 16.4));
    System.out.println("here");*/
       ultraSonicTest();
  }

  public void ultraSonicTest() {
     analog = new AnalogInput(0);
     System.out.println(analog.getValue());

  }
}
