package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class MoveClimbArmBack extends Command {
  double target;

  public MoveClimbArmBack(double target) {
    requires(Robot.climbArmBack);
    this.target = target;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climbArmBack.setTarget(target);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // SmartDashboard.putBoolean("MCAback", Robot.climbArmBack.isOnTarget());
    return Robot.climbArmBack.isOnTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}