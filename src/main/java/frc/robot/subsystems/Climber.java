// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private VictorSPX climberLeft, climberRight;

  public Climber() {
    climberLeft = new VictorSPX(Constants.CLIMBER_LEFT);
    climberRight = new VictorSPX(Constants.CLIMBER_RIGHT);
  }
// Must check for positive or negative power
  public void extend(){
    climberLeft.set(ControlMode.PercentOutput, 0.5);
    climberRight.set(ControlMode.PercentOutput, 0.5);
  }
// Must check for positive or negative power
  public void retract(){
    climberLeft.set(ControlMode.PercentOutput, -0.5);
    climberRight.set(ControlMode.PercentOutput, -0.5);
  }

  public void stop(){
    climberLeft.set(ControlMode.PercentOutput, 0);
    climberRight.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
