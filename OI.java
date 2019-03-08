package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Climb;
import frc.robot.commands.MoveCargoArm;
import frc.robot.commands.MoveHatchArm;

//Joytick and gamepad are defined here
public final class OI {
    public final XboxController xbox = new XboxController(0);
    public final XboxController xbox2 = new XboxController(2);    
    public final Joystick stick = new Joystick(1);
    
    // Buttons are called 
    final JoystickButton buttonA = new JoystickButton(xbox, 1);
    final JoystickButton buttonX = new JoystickButton(xbox, 3);
    final JoystickButton buttonY = new JoystickButton(xbox, 4);
    final JoystickButton buttonB = new JoystickButton(xbox, 2 );
    final JoystickButton buttonLB = new JoystickButton(xbox, 5);
    final JoystickButton buttonRB = new JoystickButton(xbox, 6);
    final JoystickButton buttonBack = new JoystickButton(xbox, 7);
    final JoystickButton buttonStart = new JoystickButton(xbox, 8);
    final JoystickButton buttonGreenA = new JoystickButton(xbox2, 1);
    final JoystickButton buttonBlueX = new JoystickButton(xbox2, 3);
    final JoystickButton buttonYellowY = new JoystickButton(xbox2, 4);
    // getTriggerAxis 


    public OI() {
    // Define what buttons do what
        buttonA.toggleWhenPressed(new MoveHatchArm(0));
        buttonX.toggleWhenPressed(new MoveHatchArm(122));
        buttonY.toggleWhenPressed(new MoveHatchArm(145));
        buttonB.toggleWhenActive(new MoveHatchArm(109));
        buttonLB.toggleWhenPressed(new MoveCargoArm(-52)); // down
        buttonRB.toggleWhenPressed(new MoveCargoArm(-90)); // up
        buttonBack.toggleWhenPressed(new MoveCargoArm(0));
        buttonGreenA.toggleWhenPressed(new Climb());

    }
}
