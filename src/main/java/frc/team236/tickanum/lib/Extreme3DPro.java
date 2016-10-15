package frc.team236.tickanum.lib;

import edu.wpi.first.wpilibj.Joystick;

public class Extreme3DPro extends Joystick implements VectorSource {

	Joystick stick;

	public Extreme3DPro(int port) {
		super(port);
	}

	@Override
	public Vector getVector() {
		return new Vector(this.getX(), this.getY(), this.getZ());
	}

}
