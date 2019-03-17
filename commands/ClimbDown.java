package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class ClimbDown extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ClimbDown() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    requires(Robot.climbArmFront);
    requires(Robot.climbArmBack);
    // requires(Robot.climbCrawl);

    // Raise the robot up    
    // addParallel(new MoveClimbArmFront(6144));
    // addSequential(new MoveClimbArmBack(6144));
    // Moves the robot forward
    // addSequential(new MoveClimbCrawl(2.0, 0.5));
    // Set the robot down
    addParallel(new MoveClimbArmFront(0));
    addSequential(new MoveClimbArmBack(0));
  }
}
