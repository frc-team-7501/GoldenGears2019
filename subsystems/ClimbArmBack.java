package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.RobotMap;
import frc.robot.extensions.PID;

/**
 * Add your docs here.
 */
public class ClimbArmBack extends Subsystem {
  // ToDo  replace with Talon
  WPI_TalonSRX pivotMotor = new WPI_TalonSRX(RobotMap.encoderClimbBack);
  // ToDo research how to declare encoder directly to Talon  
  Encoder pivotEncoder = new Encoder(RobotMap.encoderClimbBack, RobotMap.encoderClimbBack + 1); 
  PID pid = new PID(0.015, 0.001, 0.001) {
    @Override
    public void useOutput(double output) {
      //SmartDashboard.putNumber("ClimbBackPID out", output);
      setMotor(output);
    }

    @Override
    public double getInput() {
      return getEncoder();
    }
  };

  public ClimbArmBack() {
    pivotEncoder.reset();
  }

  public double getTarget() {
    return pid.getSetpoint();
  }

  public void setTarget(double target) {
    pid.setSetpoint(target);
  }

  public double getEncoder() {
    return pivotEncoder.getDistance();
  }

  public void setMotor(double speed) {
    pivotMotor.set(speed);
  }

  public boolean isOnTarget() {
    return Math.abs(pid.getSetpoint() - pivotEncoder.getDistance()) < 2;
  }

  public void runPID() {
    pid.execute();
  }

  @Override
  public void initDefaultCommand() {
  }

  public void log() {
    // SmartDashboard.putNumber("ClimbBack position", pivotEncoder.getDistance());
    // SmartDashboard.putNumber("CLimbBack target", pid.getSetpoint());
    // SmartDashboard.putNumber("ClimbBackPID last error", pid.getLastError());

  }
  }
