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

    //LIMELIGHT DISTANCE SETTINGS       
     

    public static double convertToMeters = 1/39.37;
    // how many degrees back is your limelight rotated from perfectly vertical?
    public static double limelightMountAngleDegrees = 46.0;
    // distance from the center of the Limelight lens to the floor
    public static double limelightHeight = 32.0 * convertToMeters;
    // distance from the target to the floor
    public static double goalHeightInches = 104.0 * convertToMeters;

    

    public static double driveGearRatio = 18;
    
    public static double MetersPerPulse = (6 * Math.PI) / ((double) 2048 * driveGearRatio);

    /**
     * 0 = left
     * 1 = center
     * 2 = right
     */
    //Set this before the game, this will control the autonomous starting mode.
    public static int autoMode = 0;
    
    //Steering PIDs 
    public static double sP = 0.025;
    public static double sI = 0.0445;
    public static double sD = 0.0035;
    public static double sILimit = 0.7;

    public static double steeringModifier = 0.45;


    //Climber limits 
    //names are flipped, rev is highest, non-rev is lowest
    public static float climberLimit = 5;
    public static float revClimberLimit = -150;

    public static double autoSpeed = 0.6;


}
