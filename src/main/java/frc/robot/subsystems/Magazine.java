// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Magazine extends SubsystemBase {
  private VictorSPX magazineMotor;
  public Magazine() {
    magazineMotor = new VictorSPX(Constants.MAGAZINE_MOTOR);
  }

  public void magazineRun(Joystick mechRemote) {

    double leftPower = deadBand(-mechRemote.getRawAxis(Constants.LEFT_JOYSTICK));
    magazineMotor.set(ControlMode.PercentOutput, leftPower);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double deadBand(double power){
    if (Math.abs(power) < 0.05){
      return 0;
    }else{
      return power;
    }
  }
}
