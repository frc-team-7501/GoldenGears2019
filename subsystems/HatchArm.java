package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.extensions.PID;

 
public class HatchArm extends Subsystem {
  WPI_TalonSRX pivotMotor = new WPI_TalonSRX(RobotMap.talonHatchArm);
  Encoder pivotEncoder = new Encoder(RobotMap.encoderHatchArm, RobotMap.encoderHatchArm + 1);
  PID pid = new PID(0.015, 0.001, 0.001) {
    @Override
    public void useOutput(double output) {
      //SmartDashboard.putNumber("HatchPID out", output);
      setMotor(output);
    }
  
    @Override
    public double getInput() {
      return getEncoder();
    }
  };

  public HatchArm() {
    pivotEncoder.reset();
    pivotMotor.configPeakCurrentDuration(0);
    pivotMotor.configPeakCurrentLimit(10);
    pivotMotor.configContinuousCurrentLimit(10); 
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
    //  SmartDashboard.putNumber("Hatch position", pivotEncoder.getDistance());
    //  SmartDashboard.putNumber("Hatch target", pid.getSetpoint());
    //  SmartDashboard.putNumber("HacthPID last error", pid.getLastError());
  }
}
