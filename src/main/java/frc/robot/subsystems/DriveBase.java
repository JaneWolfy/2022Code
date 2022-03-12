// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveBase extends SubsystemBase {
  boolean aToggle = true;
  boolean fast = true;
  private TalonFX backLeft, frontRight, frontLeft, backRight;

  double leftPosition, rightPosition;
  /** Creates a new DriveBase. */
  public DriveBase() { 

    //Created drivetrain motors
   //Sets up back left 
    backLeft = new TalonFX(Constants.BACK_LEFT);
    backLeft.configFactoryDefault();
    backLeft.setNeutralMode(NeutralMode.Coast);

    backLeft.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    backLeft.setSensorPhase(true);
    backLeft.setInverted(false);

    backLeft.configNominalOutputForward(0,30);
    backLeft.configNominalOutputReverse(0, 30);
    backLeft.configPeakOutputForward(1, 30);
    backLeft.configPeakOutputReverse(-1, 30);
    
    backLeft.configAllowableClosedloopError(0, 0, 30);

    backLeft.config_kF(0, 0.0, 30);
    backLeft.config_kP(0, 0.1554, 30);
    backLeft.config_kI(0, 0.0, 30);
    backLeft.config_kD(0, 0, 30);

    frontLeft = new TalonFX(Constants.FRONT_LEFT);
    frontLeft.configFactoryDefault();
    frontLeft.setNeutralMode(NeutralMode.Coast);

    frontLeft.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    frontLeft.setSensorPhase(true);
    frontLeft.setInverted(false);

    frontLeft.configNominalOutputForward(0,30);
    frontLeft.configNominalOutputReverse(0, 30);
    frontLeft.configPeakOutputForward(1, 30);
    frontLeft.configPeakOutputReverse(-1, 30);
    
    frontLeft.configAllowableClosedloopError(0, 0, 30);

    frontLeft.config_kF(0, 0.0, 30);
    frontLeft.config_kP(0, 0.1554, 30);
    frontLeft.config_kI(0, 0.0, 30);
    frontLeft.config_kD(0, 0, 30);

    frontRight = new TalonFX(Constants.FRONT_RIGHT);
    frontRight.configFactoryDefault();
    frontRight.setNeutralMode(NeutralMode.Coast);

    frontRight.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    frontRight.setSensorPhase(true);
    frontRight.setInverted(false);

    frontRight.configNominalOutputForward(0,30);
    frontRight.configNominalOutputReverse(0, 30);
    frontRight.configPeakOutputForward(1, 30);
    frontRight.configPeakOutputReverse(-1, 30);
    
    frontRight.configAllowableClosedloopError(0, 0, 30);

    frontRight.config_kF(0, 0.0, 30);
    frontRight.config_kP(0, 0.1554, 30);
    frontRight.config_kI(0, 0.0, 30);
    frontRight.config_kD(0, 0, 30);


    backRight = new TalonFX(Constants.BACK_RIGHT);
    backRight.configFactoryDefault();
    backRight.setNeutralMode(NeutralMode.Coast);

    backRight.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    backRight.setSensorPhase(true);
    backRight.setInverted(false);

    backRight.configNominalOutputForward(0,30);
    backRight.configNominalOutputReverse(0, 30);
    backRight.configPeakOutputForward(1, 30);
    backRight.configPeakOutputReverse(-1, 30);
    
    backRight.configAllowableClosedloopError(0, 0, 30);

    backRight.config_kF(0, 0.0, 30);
    backRight.config_kP(0, 0.1554, 30);
    backRight.config_kI(0, 0.0, 30);
    backRight.config_kD(0, 0, 30);
    
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driverControls(Joystick driverRemote){
    double leftPower = deadBand(-driverRemote.getRawAxis(Constants.LEFT_JOYSTICK));
    double rightPower = deadBand(driverRemote.getRawAxis(Constants.RIGHT_JOYSTICK));
    //System.out.println("Left Joystick: " + driverRemote.getRawAxis(Constants.LEFT_JOYSTICK) + " Right Joystick: " + driverRemote.getRawAxis(Constants.RIGHT_JOYSTICK));
    //System.out.println("Left Power: " + leftPower +" Right Power: " + rightPower);
    backLeft.set(ControlMode.PercentOutput, leftPower);
    frontLeft.set(ControlMode.PercentOutput, leftPower);
    frontRight.set(ControlMode.PercentOutput, rightPower);
    backRight.set(ControlMode.PercentOutput, rightPower);

  
  
  } 

  public double deadBand(double power){
    if (Math.abs(power) < 0.05){
      return 0;
    }else{
      return power;
    }
  }

  /*private void updateDistance(){
    leftPosition = (backLeft.getSelectedSensorPosition() + frontLeft.getSelectedSensorPosition()) / 2;
    rightPosition = (backRight.getSelectedSensorPosition() + frontRight.getSelectedSensorPosition()) / 2;
  }*/

  public void autoDistance(int time){
    /*double circumfrence = 6 * Math.PI;
    double leftRotations = leftDistance /circumfrence ; 
    double leftTargetPositionRotations = leftRotations * 8.45 *2048;
    double rightRotations = rightDistance /circumfrence ; 
    double rightTargetPositionRotations = rightRotations * 8.45 *2048;

    
    backLeft.set(TalonFXControlMode.Position, backLeft.getSelectedSensorPosition()+leftTargetPositionRotations);
    frontLeft.set(TalonFXControlMode.Position, backLeft.getSelectedSensorPosition()+leftTargetPositionRotations);
    frontRight.set(TalonFXControlMode.Position, frontRight.getSelectedSensorPosition()-rightTargetPositionRotations);
    backRight.set(TalonFXControlMode.Position, frontRight.getSelectedSensorPosition()-rightTargetPositionRotations);*/
    
    backLeft.set(ControlMode.PercentOutput, -.3);
    frontLeft.set(ControlMode.PercentOutput, -.3);
    backRight.set(ControlMode.PercentOutput, -.3);
    frontRight.set(ControlMode.PercentOutput, -.3);

    msleep(time);

    backLeft.set(ControlMode.PercentOutput, 0);
    frontLeft.set(ControlMode.PercentOutput, 0);
    backRight.set(ControlMode.PercentOutput, 0);
    frontRight.set(ControlMode.PercentOutput, 0);

  }

  public void msleep(int time) {
    try{
      Thread.sleep(time);
    } catch(InterruptedException e) {
      System.out.println("got interrupted");
    }
  }
}
