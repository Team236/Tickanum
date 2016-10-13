package frc.team236.tickanum;

import edu.wpi.first.wpilibj.Joystick;
import frc.team236.tickanum.lib.ControllerType;

public class Settings {

	public Joystick leftStick, rightStick;
	public ControllerType controllerType;
	public int leftFrontPort, leftBackPort, rightFrontPort, rightBackPort;

	public Settings() {
		leftFrontPort = 0;
		leftBackPort = 1;
		rightFrontPort = 2;
		rightBackPort = 3;
	}
}
