// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GrantsBaby extends SubsystemBase {
  /** Creates a new RotatingBar. */
  private TalonFX babyMotor;
  public GrantsBaby() {
    babyMotor = new TalonFX(Constants.BABY);
    babyMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotate(Joystick mechRemote){
    double leftPower = deadBand(-mechRemote.getRawAxis(Constants.RIGHT_JOYSTICK));
    babyMotor.set(ControlMode.PercentOutput, leftPower);
  }

  public double deadBand(double power){
    if (Math.abs(power) < 0.05){
      return 0;
    }else{
      return power;
    }
  }
}
