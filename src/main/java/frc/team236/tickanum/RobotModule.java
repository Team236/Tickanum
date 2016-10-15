package frc.team236.tickanum;

import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RobotModule extends IterativeModule {

	public static Logger logger;

	@Override
	public String getModuleName() {
		return "Tickanum";
	}

	@Override
	public String getModuleVersion() {
		return "1.0.0";
	}

	@Override
	public void robotInit() {
		logger = new Logger("Tickanum", Logger.ATTR_DEFAULT);
	}
}
