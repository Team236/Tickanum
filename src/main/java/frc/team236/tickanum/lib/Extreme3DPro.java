package frc.team236.tickanum.lib;

import edu.wpi.first.wpilibj.Joystick;

public class Extreme3DPro extends Joystick implements VectorSource {

	Joystick stick;

	public Extreme3DPro(int port) {
		super(port);
	}

	@Override
	public Vector getVector() {
		return new Vector(this.getX(), -this.getY(), this.getZ());
	}

	/**
	 * Use pythagorean theorem to get the magnitude of the joystick position
	 * vector
	 */
	public double getMagnitude() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}

}
