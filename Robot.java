package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.ClimbArmBack;
import frc.robot.subsystems.ClimbArmFront;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;

public class Robot extends TimedRobot {
    public static OI oi;

    // Init subsystems here 
    public static DriveTrain driveTrain = new DriveTrain();
    public static HatchArm hatchArm = new HatchArm();
    public static CargoArm cargoArm = new CargoArm();
    public static ClimbArmBack climbArmBack = new ClimbArmBack();
    public static ClimbArmFront climbArmFront = new ClimbArmFront(); 

    @Override
    public void robotInit() {
        oi = new OI();
        // Captures camera video and is sent to the RoboRio 
        CameraServer.getInstance().startAutomaticCapture();
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        hatchArm.runPID();
        cargoArm.runPID();
        climbArmBack.runPID();
        climbArmFront.runPID(); 
      
    }

    @Override
    public void robotPeriodic() {
        log();
    }

    // Send information to the SmartDashboard from each subsystem
    private void log() {
        driveTrain.log();
        hatchArm.log();
        cargoArm.log(); 
        climbArmBack.log();
        climbArmFront.log(); 
    }
}