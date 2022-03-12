// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Talon Motor CAN Numbers
    public static final int FRONT_LEFT = 1;
    public static final int BACK_LEFT = 2;
    public static final int BACK_RIGHT = 4;
    public static final int FRONT_RIGHT = 3;
    public static final int SHOOTER_1 = 5;
    public static final int SHOOTER_2 = 6;
    public static final int BABY = 7;


    //Joystick numbers
    public static final int DRIVER_REMOTE = 0;
    public static final int MECH_REMOTE = 1;


    //Joystick buttons
    public static final int LEFT_JOYSTICK = 1;
    public static final int L2 = 2;
    public static final int R2 = 3;
    public static final int RIGHT_JOYSTICK = 5;
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3; 
    public static final int Y = 4; 
    public static final int L1 = 5; 
    public static final int R1 = 6; 
    
    
    


    

    //Mesurments
    public static final double TARGET_HEIGHT = 91;
    public static final double CAMERA_HEIGHT = 37;
    public static final double LIMELIGHT_ANGLE = -.37;
  

    //VictorSPX
    public static final int CLIMBER_LEFT = 11;
    public static final int CLIMBER_RIGHT = 9;
    public static final int INTAKE_LIFT = 12;
    public static final int INTAKE_WHEELS = 8;
    public static final int MAGAZINE_MOTOR = 10;

   

    
}
