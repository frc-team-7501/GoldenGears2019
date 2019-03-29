
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX; 

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveRobotManual;

/* This is where each motor controller is called to match its corresponding wheel or motor.
*the victorDrives are called in robotmap.java
*/
public class DriveTrain extends Subsystem {
  WPI_VictorSPX driveFL = new WPI_VictorSPX(RobotMap.victorDriveFrontLeft);
  WPI_VictorSPX driveFR = new WPI_VictorSPX(RobotMap.victorDriveFrontRight);
  WPI_VictorSPX driveBL = new WPI_VictorSPX(RobotMap.victorDriveBackLeft);
  WPI_VictorSPX driveBR = new WPI_VictorSPX(RobotMap.victorDriveBackRight);

  /*This is where each side of the robot's drivetrain is called. 
  *i.e The left motors make up the left group
  *This group is created to make more organized code
  */
  SpeedControllerGroup leftGroup = new SpeedControllerGroup(driveFL, driveBL);
  SpeedControllerGroup rightGroup = new SpeedControllerGroup(driveFR, driveBR);
  DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  public DriveTrain() {
   // This is set to invert the left group in order to have both groups moving in the same direction.
    leftGroup.setInverted(true);
    drive.setDeadband(0.06);
  }

  // Sets/calls rotation and linear speed (Check this)
  public void arcadeDrive(double rotationSpeed, double forwardSpeed) {
    drive.arcadeDrive(rotationSpeed, forwardSpeed);
  }

  // If no other command is being used the defult will run
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveRobotManual());
  }

  public void log() {

  }
}
