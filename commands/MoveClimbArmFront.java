package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class MoveClimbArmFront extends Command {
    double target; 

    public MoveClimbArmFront(double target) {
      requires(Robot.climbArmFront);
      this.target = target;
    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
      Robot.climbArmFront.setTarget(target);
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      // SmartDashboard.putBoolean("MCAFront",Robot.climbArmFront.isOnTarget());
      return Robot.climbArmFront.isOnTarget();
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