package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.RobotMap;
import frc.robot.extensions.PID;

/**
 * Add your docs here.
 */
public class ClimbArmFront extends Subsystem {
  WPI_VictorSPX pivotMotor = new WPI_VictorSPX(RobotMap.encoderClimbFront); 
  Encoder pivotEncoder = new Encoder(RobotMap.encoderClimbFront, RobotMap.encoderClimbFront + 1); 
  PID pid = new PID(0.015, 0.001, 0.001) {
    @Override
    public void useOutput(double output) {
      //SmartDashboard.putNumber("CargoPID out", output);
      setMotor(output);
    }

    @Override
    public double getInput() {
      return getEncoder();
    }
  };

  public ClimbArmFront() {
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
    // SmartDashboard.putNumber("Cargo position", pivotEncoder.getDistance());
    // SmartDashboard.putNumber("Cargo target", pid.getSetpoint());
    // SmartDashboard.putNumber("CargoPID last error", pid.getLastError());

  }
  }
