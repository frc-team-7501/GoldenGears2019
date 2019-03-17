package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.MoveClimbArmFront;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.ClimbArmBack;
import frc.robot.subsystems.ClimbArmFront;
import frc.robot.subsystems.ClimbCrawl;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;

public class Robot extends TimedRobot {
    public static OI oi;
    double dXboxY;

    // Init subsystems here 
    public static DriveTrain driveTrain = new DriveTrain();
    public static HatchArm hatchArm = new HatchArm();
    public static CargoArm cargoArm = new CargoArm();
    public static ClimbArmBack climbArmBack = new ClimbArmBack();
    public static ClimbArmFront climbArmFront = new ClimbArmFront(); 
    public static ClimbCrawl climbCrawl = new ClimbCrawl();

    @Override
    public void robotInit() {
        oi = new OI();
        // Captures camera video and is sent to the RoboRio 
        CameraServer.getInstance().startAutomaticCapture();
        climbArmFront.setup();
        climbArmBack.setup();
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

        // Use the left joystick to move the arm
		dXboxY = Robot.oi.xbox2.getY();
		if ((dXboxY >= .1) || (dXboxY <= -.1)) {
			//ClimbArmFront.manualArmMove(dXboxY);
		}
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
        climbCrawl.log();
    }
}