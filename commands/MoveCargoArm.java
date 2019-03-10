package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveCargoArm extends Command {
  double target;

  public MoveCargoArm(double target) {
    //This is explaining that the command MoveCargoArm requuires cargoArm defined in Robot.Java
    requires(Robot.cargoArm);
    //this.target = target;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveTrain.arcadeDrive(Robot.oi.stick.getX() / -1.65, Robot.oi.stick.getY() / 1.35);
    //Robot.cargoArm.setTarget(target);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.cargoArm.isOnTarget();
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
