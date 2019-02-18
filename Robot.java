package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;

public class Robot extends TimedRobot {
    public static OI oi;

    // Init subsystems here
    public static DriveTrain driveTrain = new DriveTrain();
    public static HatchArm hatchArm = new HatchArm();
    public static CargoArm cargoArm = new CargoArm();

    @Override
    public void robotInit() {
        oi = new OI();
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
    }

    @Override
    public void robotPeriodic() {
        log();
    }

    // Send information to the SmartDashboard from eacah subsystem
    private void log() {
        driveTrain.log();
        hatchArm.log();
        cargoArm.log(); 
    }
}