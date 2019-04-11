package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClimbDown;
import frc.robot.commands.ClimbUp;
import frc.robot.commands.ClimbUpLevelTwo;
import frc.robot.commands.MoveCargoArm;
import frc.robot.commands.MoveHatchArm;
// import frc.robot.commands.MoveClimbArmBack;
// import frc.robot.commands.MoveClimbArmFront;
// import frc.robot.commands.MoveClimbCrawl;

//Joytick and gamepad are defined here
public final class OI {
    public final XboxController xbox = new XboxController(0);
    public final XboxController xbox2 = new XboxController(1);
    public final Joystick stick = new Joystick(2);

    // Buttons are called
    final JoystickButton button1A = new JoystickButton(xbox, 1);
    final JoystickButton button1B = new JoystickButton(xbox, 2);
    final JoystickButton button1X = new JoystickButton(xbox, 3);
    final JoystickButton button1Y = new JoystickButton(xbox, 4);
    final JoystickButton button1LB = new JoystickButton(xbox, 5);
    final JoystickButton button1RB = new JoystickButton(xbox, 6);
    final JoystickButton button1Back = new JoystickButton(xbox, 7);
    final JoystickButton button1Start = new JoystickButton(xbox, 8);
    final JoystickButton button2A = new JoystickButton(xbox2, 1);
    final JoystickButton button2B = new JoystickButton(xbox2, 2);
    final JoystickButton button2X = new JoystickButton(xbox2, 3);
    final JoystickButton button2Y = new JoystickButton(xbox2, 4);
    // getTriggerAxis

    public OI() {
        // Define what buttons do what
        button1A.whenPressed(new MoveHatchArm(0));
        button1X.whenPressed(new MoveHatchArm(RobotMap.hatchArmMiddle));
        button1Y.whenPressed(new MoveHatchArm(RobotMap.hatchArmHigh));
        button1B.whenPressed(new MoveHatchArm(RobotMap.hatchArmLow));
        button1LB.whenPressed(new MoveCargoArm(RobotMap.cargoArmLow)); // down
        button1RB.whenPressed(new MoveCargoArm(RobotMap.cargoArmHigh)); // up
        button1Back.whenPressed(new MoveCargoArm(0));
        button2X.toggleWhenPressed(new ClimbUp());
        // button2A.toggleWhenPressed(new MoveClimbCrawl(4, -1));
        button2Y.toggleWhenPressed(new ClimbDown());
        button2B.toggleWhenPressed(new ClimbUpLevelTwo());
    }
}