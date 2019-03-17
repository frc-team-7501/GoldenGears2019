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
 * Also includes constants used within the robot program.
 */
public class RobotMap {
    // Victor SPXs
    public static final int victorClimbCrawl = 5;  
    public static final int victorDriveFrontLeft = 4;
    public static final int victorDriveFrontRight = 2;
    public static final int victorDriveBackLeft = 3;
    public static final int victorDriveBackRight = 1;

    // Talon SRXs
    public static final int talonHatchArm = 11;
    public static final int talonCargoArm = 12;
    public static final int talonClimbFront = 13;
    public static final int talonClimbBack = 14;
    
    // Encoders
    public static final int encoderHatchArm = 0; // and 1 
    public static final int encoderCargoArm = 2; // and 3 
    // ToDo is this needed with the direct connection to the Talon?
    public static final int encoderClimbFront = 4; // and 5 
    public static final int encoderClimbBack = 6; // and 7

    	/** 
 	 * Which PID slot to pull gains from. Starting 2018, you can choose from 
 	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based 
 	 * configuration. 
	 */ 
 	public static final int kSlotIdx = 0; 
 
 
 	/** 
 	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For 
 	 * now we just want the primary one. 
	 */ 
 	public static final int kPIDLoopIdx = 0; 
 
 
 	/** 
	 * set to zero to skip waiting for confirmation, set to nonzero to wait and 
 	 * report to DS if action fails. 
 	 */ 
 	public static final int kTimeoutMs = 30; 
 
 
 	/** 
 	 * Gains used in Motion Magic, to be adjusted accordingly 
      * Gains(kp, ki, kd, kf, izone, peak output); 
      */ 
     public static final Gains kGains = new Gains(0.46987, 0.00001, 0.001, 30, 0, 1); 

}