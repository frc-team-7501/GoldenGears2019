package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.CargoArm;
import frc.robot.subsystems.ClimbArmBack;
import frc.robot.subsystems.ClimbArmFront;
import frc.robot.subsystems.ClimbCrawl;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.HatchArm;

public class Robot extends TimedRobot {
    public static OI oi;
    private double dXboxY;
    private double dXboxX;
    public boolean hasClimbed = false;

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

        /* Use the left joystick to move the arm
        * If the robot has climbed(true) the joystick will not be able to function
        *If the robot has not climbed(false) and the output is greater than or equal to .1 or -.1 the robot arms will move 
        *If the robot has not climbed(false) and the output is less than .1 or -.1 the robot will not move.
        */
        dXboxY = Robot.oi.xbox2.getY(Hand.kLeft);
        dXboxX = Robot.oi.xbox2.getY(Hand.kRight);
        this.hasClimbed = Robot.climbArmFront.hasClimbed;

        if (hasClimbed == false) {
            if ((dXboxY >= .1) || (dXboxY <= -.1)) {
                Robot.climbArmFront.manualArmMove(dXboxY);
            } else { 
                Robot.climbArmFront.manualArmMove(0);   
            }
            if ((dXboxX >= .1) || (dXboxX <= -.1)) {
                Robot.climbArmBack.manualArmMove(dXboxX);
            } else { 
                Robot.climbArmBack.manualArmMove(0);   
            }
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