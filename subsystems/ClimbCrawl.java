package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.RobotMap;

public class ClimbCrawl extends Subsystem {
  WPI_VictorSPX pivotMotor = new WPI_VictorSPX(RobotMap.victorClimbCrawl); 

  // public ClimbCrawl() {
  // }
  public void setMotor(double speed) {
    pivotMotor.set(speed);
     SmartDashboard.putNumber("in set motor ", 1);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void log() {
    
   }
  }
 