package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.RobotMap;

public class ClimbCrawl extends Subsystem {
  WPI_VictorSPX pivotMotor = new WPI_VictorSPX(RobotMap.victorClimbCrawl);
  public boolean enableCrawl = false;

  // public ClimbCrawl() {
  // }
  public void setMotor(double speed) {
    pivotMotor.set(speed);
  }

  /* public void toggleEnabled() {
  //enableCrawl = !enableCrawl;
  }*/

  @Override
  public void initDefaultCommand() {
  }

  public void log() {

  }
}