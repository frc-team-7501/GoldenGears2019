package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
// import frc.robot.subsystems.DriveTrain;

public class DriveRobotManual extends Command {
  private double robotSpeed = 1.4;

  public DriveRobotManual() {
    requires(Robot.driveTrain);
    requires(Robot.climbCrawl);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // This enables full power(TURBOOOO) when the trigger is pulled
    if (Robot.oi.stick.getTrigger()) {
      robotSpeed = 1.3;
    } else {
      robotSpeed = 1.4;
    }

    // SmartDashboard.putBoolean("Trigger Value", Robot.oi.stick.getTrigger());
    Robot.driveTrain.arcadeDrive(Robot.oi.stick.getX() / -1.65, Robot.oi.stick.getY() / robotSpeed);
    if (Robot.climbCrawl.enableCrawl) {
      Robot.driveTrain.arcadeDrive(Robot.oi.stick.getX() / -2, Robot.oi.stick.getY() / robotSpeed);
      Robot.climbCrawl.setMotor(Robot.oi.stick.getY());
    }else {
      Robot.driveTrain.arcadeDrive(Robot.oi.stick.getX() / -1.65, Robot.oi.stick.getY() / robotSpeed);

    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.arcadeDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
