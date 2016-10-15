package frc.team236.tickanum.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.tickanum.Tickanum;
import frc.team236.tickanum.lib.Vector;

public class DriveWithJoystick extends Command {

	private Tickanum tick;

	public DriveWithJoystick(Tickanum _tick) {
		this.tick = _tick;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Vector v = tick.stick.getVector();
		// We use a negative because we're kind of "undoing" the robot's rotation
		v.rotate(-tick.getAngle());
		tick.set(v);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		tick.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
