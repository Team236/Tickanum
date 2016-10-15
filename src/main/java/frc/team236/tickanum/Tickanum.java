package frc.team236.tickanum;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.tickanum.commands.DriveWithJoystick;
import frc.team236.tickanum.lib.ControllerType;
import frc.team236.tickanum.lib.Extreme3DPro;
import jaci.openrio.toast.lib.registry.Registrar;

public class Tickanum extends Subsystem {

	public SpeedController leftFront, leftBack, rightFront, rightBack;
	public AHRS gyro;
	public Extreme3DPro stick;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick(this));
	}

	public Tickanum(Settings settings) {
		leftFront = makeMotor(settings.leftFrontPort, settings.controllerType);
		leftBack = makeMotor(settings.leftBackPort, settings.controllerType);
		rightFront = makeMotor(settings.rightFrontPort, settings.controllerType);
		rightBack = makeMotor(settings.rightBackPort, settings.controllerType);

		stick = settings.stick;
	}

	private static SpeedController makeMotor(int port, ControllerType type) {
		SpeedController m;

		switch (type) {
		case VICTORSP:
			m = Registrar.victorSP(port);
			break;
		case VICTOR:
			m = Registrar.victor(port);
			break;
		case TALON:
			m = Registrar.talon(port);
			break;
		case JAGUAR:
			m = Registrar.jaguar(port);
			break;
		default:
			m = Registrar.victorSP(port);
		}
		return m;
	}

	/**
	 * Set the motion of the robot.
	 * 
	 * @param angle
	 *            The angle (from straight ahead) toward which the bot should
	 *            move (in radians)
	 * @param mag
	 *            The speed at which the robot should move
	 * @param rot
	 *            The rate of rotation
	 */
	public void set(double angle, double mag, double rot) {
		// Set the speeds using the vector
		setLeftFront(angle, mag, rot);
		setLeftBack(angle, mag, rot);
		setRightFront(angle, mag, rot);
		setRightBack(angle, mag, rot);
	}

	public double getAngle() {
		return 0;//gyro.getAngle();
	}

	public void stop() {
		leftFront.stopMotor();
		leftBack.stopMotor();
		rightFront.stopMotor();
		rightBack.stopMotor();
	}

	private void setLeftFront(double angle, double mag, double rot) {
		double speed = mag * Math.sin(angle + Math.PI / 4) + rot;
		leftFront.set(speed);
	}

	private void setLeftBack(double angle, double mag, double rot) {
		double speed = mag * Math.cos(angle + Math.PI / 4) + rot;
		leftBack.set(speed);
	}

	private void setRightFront(double angle, double mag, double rot) {
		double speed = mag * Math.cos(angle + Math.PI / 4) - rot;
		rightFront.set(speed);
	}

	private void setRightBack(double angle, double mag, double rot) {
		double speed = mag * Math.sin(angle + Math.PI / 4) - rot;
		rightBack.set(speed);
	}
}
