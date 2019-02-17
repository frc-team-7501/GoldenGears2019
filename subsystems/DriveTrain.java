
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveRobotManual;


public class DriveTrain extends Subsystem {
  WPI_VictorSPX driveFL = new WPI_VictorSPX(RobotMap.victorDriveFrontLeft);
  WPI_VictorSPX driveFR = new WPI_VictorSPX(RobotMap.victorDriveFrontRight);
  WPI_VictorSPX driveBL = new WPI_VictorSPX(RobotMap.victorDriveBackLeft);
  WPI_VictorSPX driveBR = new WPI_VictorSPX(RobotMap.victorDriveBackRight);
  SpeedControllerGroup leftGroup = new SpeedControllerGroup(driveFL, driveBL);
  SpeedControllerGroup rightGroup = new SpeedControllerGroup(driveFR, driveBR);
  DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

  public DriveTrain() {
    leftGroup.setInverted(true);
    drive.setDeadband(0.06);
  }

  public void arcadeDrive(double rotationSpeed, double forwardSpeed) {
    drive.arcadeDrive(rotationSpeed, forwardSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveRobotManual());
  }

  public void log() {

  }
}
