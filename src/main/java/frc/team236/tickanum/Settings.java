package frc.team236.tickanum;

import frc.team236.tickanum.lib.ControllerType;
import frc.team236.tickanum.lib.Extreme3DPro;

public class Settings {

	public Extreme3DPro stick;
	public ControllerType controllerType;
	public int leftFrontPort, leftBackPort, rightFrontPort, rightBackPort;

	public Settings() {
		leftFrontPort = 0;
		leftBackPort = 1;
		rightFrontPort = 2;
		rightBackPort = 3;
	}
}
