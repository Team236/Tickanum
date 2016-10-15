package frc.team236.tickanum.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team236.tickanum.Tickanum;

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
		this.tick.set(tick.stick.getDirectionRadians(), tick.stick.getMagnitude(), tick.stick.getZ());
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
