package frc.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class MoveClimbCrawl extends TimedCommand {
  double speed;

  public MoveClimbCrawl(double timeout, double speed) {
    super(timeout);
    requires(Robot.climbCrawl);
    setTimeout(2);
    this.speed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climbCrawl.setMotor(speed);
    SmartDashboard.putBoolean("is Timeout", isTimedOut());
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  public synchronized void cancel() {
    super.cancel();
    end();
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.climbCrawl.setMotor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}