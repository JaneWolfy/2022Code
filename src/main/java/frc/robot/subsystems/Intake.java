// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private VictorSPX intakeLift, intakeWheels;
  /** Creates a new Intake. */
  public Intake() {
    intakeLift = new VictorSPX(Constants.INTAKE_LIFT);
    intakeWheels = new VictorSPX(Constants.INTAKE_WHEELS);
    
    
  }

  public void lift() {
    // Must check for positive or negative power
    intakeLift.set(ControlMode.PercentOutput, 0.5);
  }

  public void lower() {
    // Must check for positive or negative power
    intakeLift.set(ControlMode.PercentOutput, -0.5);
  }

  public void wheels(Joystick mechRemote) {
    // Must check for positive or negative power
    if(mechRemote.getRawAxis(Constants.L2) !=0){
      intakeWheels.set(ControlMode.PercentOutput, mechRemote.getRawAxis(Constants.L2));
    }else if(mechRemote.getRawAxis(Constants.R2) != 0){
      intakeWheels.set(ControlMode.PercentOutput, -mechRemote.getRawAxis(Constants.R2));
    }else{
      intakeWheels.set(ControlMode.PercentOutput, 0);
    }
  }


  public void stop() {
    intakeLift.set(ControlMode.PercentOutput, 0);
    intakeWheels.set(ControlMode.PercentOutput, 0);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
 
}
