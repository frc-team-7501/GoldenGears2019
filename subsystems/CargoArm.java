package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.RobotMap;
import frc.robot.extensions.PID;

// CargoArm subsystem controls the arm moving the Cargo box on top of the robot
// The arm motor is an encoder motor so we can control how far it moves

public class CargoArm extends Subsystem {
  WPI_TalonSRX pivotMotor = new WPI_TalonSRX(RobotMap.talonCargoArm); 
  Encoder pivotEncoder = new Encoder(RobotMap.encoderCargoArm, RobotMap.encoderCargoArm + 1); 
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

  public CargoArm() {
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
