package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveClimbCrawl extends Command { 
double speed; 

    public MoveClimbCrawl(double speed) {
      requires(Robot.climbArmFront);
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
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
    
    @Override
    public synchronized void cancel() {
      super.cancel();
      end();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
      Robot.climbCrawl.setMotor(0);
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
  }