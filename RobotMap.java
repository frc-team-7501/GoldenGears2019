/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Victor SPXs
    public static final int victorClimbCrawl = 7; 
    // ToDo remove victors and replace with Talons (5 and 6)
    public static final int victorClimbBack = 6; 
    public static final int victorClimbFront = 5; 
    public static final int victorDriveFrontLeft = 4;
    public static final int victorDriveFrontRight = 2;
    public static final int victorDriveBackLeft = 3;
    public static final int victorDriveBackRight = 1;

    // Talon SRXs
    public static final int talonHatchArm = 11;
    public static final int talonCargoArm = 12;
    // ToDo update and Talons and later remove Victors(5 and 6 above)
    public static final int talonClimbFront = 13;
    public static final int talonClimbBack = 14;
    
    // Encoders
    public static final int encoderHatchArm = 0; // and 1 
    public static final int encoderCargoArm = 2; // and 3 
    // ToDo is this needed with the direct connection to the Talon?
    public static final int encoderClimbFront = 4; // and 5 
    public static final int encoderClimbBack = 6; // and 7
}