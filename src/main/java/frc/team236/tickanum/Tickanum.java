package frc.team236.tickanum;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team236.tickanum.commands.DriveWithJoystick;
import frc.team236.tickanum.lib.ControllerType;
import frc.team236.tickanum.lib.Extreme3DPro;
import frc.team236.tickanum.lib.Vector;
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

	public void set(Vector v) {
		// Set the speeds using the vector
		setLeftFront(v);
		setLeftBack(v);
		setRightFront(v);
		setRightBack(v);
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public void stop() {
		leftFront.stopMotor();
		leftBack.stopMotor();
		rightFront.stopMotor();
		rightBack.stopMotor();
	}

	private void setLeftFront(Vector v) {
		/*
		 * X:+ Y:+ Z:+
		 */
		double speed = v.x + v.y + v.z;
		speed /= 3;
		leftFront.set(speed);
	}

	private void setLeftBack(Vector v) {
		/*
		 * X:- Y:+ Z:+
		 */
		double speed = -v.x + v.y + v.z;
		speed /= 3;
		leftBack.set(speed);
	}

	private void setRightFront(Vector v) {
		/*
		 * X:- Y:+ Z:-
		 */
		double speed = -v.x + v.y - v.z;
		speed /= 3;
		rightFront.set(speed);
	}

	private void setRightBack(Vector v) {
		/*
		 * X:+ Y:+ Z:-
		 */
		double speed = v.x + v.y - v.z;
		speed /= 3;
		rightBack.set(speed);
	}
}
