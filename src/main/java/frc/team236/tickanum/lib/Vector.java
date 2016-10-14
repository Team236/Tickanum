package frc.team236.tickanum.lib;

import java.util.ArrayList;

public class Vector {
	public ArrayList<Double> components;
	public double x, y, z;

	public Vector(double _x, double _y, double _z) {
		this.x = _x;
		this.y = _y;
		this.z = _z;

		this.components = new ArrayList<Double>(3);
		this.components.add(x);
		this.components.add(y);
		this.components.add(z);
	}

	/**
	 * Rotate the vector by the given angle
	 * 
	 * @param degrees
	 *            the angle to rotate the vector in degrees
	 */
	public void rotate(double degrees) {
		double rad = Math.toRadians(degrees);
		double _x = this.x * Math.cos(rad) - this.y * Math.sin(rad);
		double _y = this.x * Math.sin(rad) + this.y * Math.cos(rad);

		this.x = _x;
		this.y = _y;
	}
}
