# Tickanum
A fully-featured mecanum drive implementation

This is Techno Ticks package, just like Updater, MotionProfile, Standard, etc.
This means that it is designed to be easy to incorporate into your robot project,

## Installation
To set up this module in your development environment, follow these steps:

1. Clone the repository  
2. Run `gradlew eclipse` for Eclipse, or `gradlew idea` for IntelliJ (Linux/Mac users should use `./gradlew` instead of `gradlew`.)  
3. Edit the `build.gradle` file to reflect your desired configuration (e.g. changing the team number)  
4. Build and integrate jars for all of the modules in /modules/modules.md

To build this module, simply run `gradlew build`.
To deploy this module to your Robot, simply run `gradlew deploy`.
If you haven't already, you can deploy [Toast](https://github.com/Open-RIO/ToastAPI) to your Robot by running `gradlew toastDeploy`.

## Using

The tickanum drive is very easy to use on your robot. It is a subsystem, so you
can just create an instance of it next to your other subsystems like so:

    public class RobotModule extends IterativeModule {

        // Subsystems
        public static Tickanum drive;
        
        public void RobotInit() {
            Settings config;
            config.controllerType = ControllerType.VICTORSP;
            config.stick = new Extreme3DPro(0);
            drive = new Tickanum(config);

In your OI.java, you will have to do things slightly differently. Instead of 
declaring your Extreme 3D Pro joystick as a wpilib `Joystick` object, you will
have to use the wrapper class provided, `Extreme3DPro`. This class implements
`VectorSource`, which allows the Mecanum Drive to get its vector inputs from
the joystick. If you're messing around with autonomous modes, make sure your
profile follower is a `VectorSource` so you can feed it to the Tickanum drive.
