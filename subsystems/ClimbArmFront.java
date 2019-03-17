package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class ClimbArmFront extends Subsystem {
	WPI_TalonSRX pivotMotor = new WPI_TalonSRX(RobotMap.talonClimbFront);
	double target; 

	public ClimbArmFront() {

	}

	public void manualArmMove(double speed) {
		pivotMotor.set(speed);
	}

	public void setTarget(double target) {
		// Use MotionMagic to move arms to a set target
		pivotMotor.set(ControlMode.MotionMagic, target);

		/* Smart dash plots */ 
 		SmartDashboard.putNumber("SensorVelFront", pivotMotor.getSelectedSensorVelocity(RobotMap.kPIDLoopIdx)); 
 		SmartDashboard.putNumber("SensorPosFront", pivotMotor.getSelectedSensorPosition(RobotMap.kPIDLoopIdx)); 
 		SmartDashboard.putNumber("MotorOutputPercentFront", pivotMotor.getMotorOutputPercent()); 
		SmartDashboard.putNumber("ClosedLoopErrorFront", pivotMotor.getClosedLoopError(RobotMap.kPIDLoopIdx)); 
		SmartDashboard.putNumber("targetFront", target);
	}

	public boolean isOnTarget() {
		return Math.abs(target - pivotMotor.getSelectedSensorPosition(RobotMap.kPIDLoopIdx)) < 110;
	  }

public void setup() {
	
	/* Factory default hardware to prevent unexpected behavior */
	pivotMotor.configFactoryDefault();

	/* Configure Sensor Source for Pirmary PID */
	pivotMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.kPIDLoopIdx,
			RobotMap.kTimeoutMs);
	/**
	 * Configure Talon SRX Output and Sesnor direction accordingly Invert Motor to
	 * have green LEDs when driving Talon Forward / Requesting Postiive Output Phase
	 * sensor to have positive increment when driving Talon Forward (Green LED)
	 */
	pivotMotor.setSensorPhase(true);
	pivotMotor.setInverted(false);

	/* Set relevant frame periods to be at least as fast as periodic rate */
	pivotMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, RobotMap.kTimeoutMs);
	pivotMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, RobotMap.kTimeoutMs);

	/* Set the peak and nominal outputs */
	pivotMotor.configNominalOutputForward(0, RobotMap.kTimeoutMs);
	pivotMotor.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
	pivotMotor.configPeakOutputForward(1, RobotMap.kTimeoutMs);
	pivotMotor.configPeakOutputReverse(-1, RobotMap.kTimeoutMs);

	/* Set Motion Magic gains in slot0 - see documentation */
	pivotMotor.selectProfileSlot(RobotMap.kSlotIdx, RobotMap.kPIDLoopIdx);
	pivotMotor.config_kF(RobotMap.kSlotIdx, RobotMap.gainFront.kF, RobotMap.kTimeoutMs);
	pivotMotor.config_kP(RobotMap.kSlotIdx, RobotMap.gainFront.kP, RobotMap.kTimeoutMs);
	pivotMotor.config_kI(RobotMap.kSlotIdx, RobotMap.gainFront.kI, RobotMap.kTimeoutMs);
	pivotMotor.config_kD(RobotMap.kSlotIdx, RobotMap.gainFront.kD, RobotMap.kTimeoutMs);

	/* Set acceleration and vcruise velocity - see documentation */
	pivotMotor.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
	pivotMotor.configMotionAcceleration(500, RobotMap.kTimeoutMs);

	/* Zero the sensor */
	pivotMotor.setSelectedSensorPosition(0, RobotMap.kPIDLoopIdx, RobotMap.kTimeoutMs);

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
